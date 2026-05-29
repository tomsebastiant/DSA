package problems.design;


import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * Tags: Design
 * Tags: Deque
 * Tags: HashTable
 * Design an in-memory rate limiter that tracks requests per user over a rolling time window.
 * Implement allow(userId, timestampSeconds) which returns true if the user has made fewer than
 * maxRequests within the last windowSeconds, and false otherwise. Each user's request history
 * is tracked independently using the provided timestamp rather than the system clock.
 *
 * Constraints:
 * 1 <= maxRequests <= 10^6
 * 1 <= windowSeconds <= 86400
 * userId is a non-empty string
 * timestampSeconds values per user are non-decreasing
 *
 * Example 1:
 *
 * Input: maxRequests=3, windowSeconds=10
 * allow("user1", 1)  // window: [1],          size=1 < 3 → true
 * allow("user1", 5)  // window: [1,5],        size=2 < 3 → true
 * allow("user1", 9)  // window: [1,5,9],      size=3 = 3 → true (added before check)
 * allow("user1", 10) // windowStart=0; [1,5,9] all stay; size=3 == maxRequests → false
 * allow("user1", 12) // windowStart=2; evict t=1; window: [5,9]; add 12 → true
 *
 * Example 2:
 *
 * Input: maxRequests=2, windowSeconds=5
 * allow("alice", 1) → true   // alice window: [1]
 * allow("bob",   1) → true   // bob tracked independently; bob window: [1]
 * allow("alice", 3) → true   // alice window: [1,3]
 * allow("alice", 5) → false  // windowStart=0; [1,3] both stay; size=2 == maxRequests
 * allow("alice", 7) → true   // windowStart=2; evict t=1; window: [3,7]
 *
 * Approach: Each user maintains a Deque of request timestamps in a ConcurrentHashMap. On each
 * allow(), expired entries (timestamp <= t - windowSeconds) are evicted from the front. A
 * per-user ReentrantLock ensures thread safety per user while letting different users proceed
 * concurrently without contention.
 */
public class M_SlidingWindowRateLimited {
    private final int maxRequests;
    private final int windowSeconds;

    // ConcurrentHashMap for safe cross-user access
    private final ConcurrentHashMap<String, Deque<Long>> userWindows;

    // Per-user locks — only same-user requests contend
    private final ConcurrentHashMap<String, ReentrantLock> userLocks;

    public M_SlidingWindowRateLimited(int maxRequests, int windowSeconds) {
        this.maxRequests   = maxRequests;
        this.windowSeconds = windowSeconds;
        this.userWindows   = new ConcurrentHashMap<>();
        this.userLocks     = new ConcurrentHashMap<>();
    }

    public boolean allow(String userId, long timestampSeconds) {
        // Atomically get-or-create queue and lock for this user
        // computeIfAbsent is atomic in ConcurrentHashMap
        userWindows.computeIfAbsent(userId, k -> new ArrayDeque<>());
        ReentrantLock lock = userLocks.computeIfAbsent(
            userId, k -> new ReentrantLock()
        );

        // Only lock at the per-user level
        // Two different users never block each other
        lock.lock();
        try {
            Deque<Long> window = userWindows.get(userId);

            // Evict outside rolling window
            long windowStart = timestampSeconds - windowSeconds;
            while (!window.isEmpty() && window.peekFirst() <= windowStart) {
                window.pollFirst();
            }

            if (window.size() < maxRequests) {
                window.addLast(timestampSeconds);
                return true;
            }

            return false;

        } finally {
            lock.unlock(); // always unlock — even if exception thrown
        }
    }
}

