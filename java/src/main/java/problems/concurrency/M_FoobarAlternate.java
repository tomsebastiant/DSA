package problems.concurrency;

import java.util.concurrent.Semaphore;

/**
 * LC: 1115
 * Tags: Design
 * https://leetcode.com/problems/print-foobar-alternately/
 * Suppose two different threads call the methods foo() and bar() simultaneously. Thread A calls
 * foo() and thread B calls bar(). Modify the class so that the two threads output "foobar"
 * exactly n times, always in that order, regardless of thread scheduling.
 *
 * Constraints:
 * 1 <= n <= 1000
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "foobar"
 * Explanation: Thread A calls foo(), thread B calls bar(). Output is "foobar" once.
 *
 * Example 2:
 *
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is output two times.
 *
 * Approach: Use two semaphores as a blocking hand-off token. fooSem starts with 1 permit so the
 * foo thread is immediately runnable; barSem starts at 0 so bar blocks until foo passes it the
 * token. After each print the current thread releases the other thread's semaphore, creating a
 * strict foo→bar→foo→bar alternation with no busy-waiting.
 *
 * Why Semaphore over the alternatives:
 *  - volatile flag + spin:      threads burn CPU in a tight while-loop waiting for the flag to
 *                               flip; wastes a whole core for the duration of each wait.
 *  - synchronized + wait/notify: works correctly but requires a shared monitor object, explicit
 *                               synchronized blocks, and a while-loop guard against spurious
 *                               wakeups — significantly more boilerplate for no extra benefit.
 *  - ReentrantLock + Condition: designed for cases that need multiple condition queues or timed
 *                               waits; overkill for a simple binary alternation.
 *  - AtomicInteger/AtomicBoolean spin: same busy-wait problem as volatile; atomic CAS is useful
 *                               for lock-free data structures, not for blocking coordination.
 *  - CountDownLatch:            single-use by design; you would need n separate latches and
 *                               cannot reset them, so it doesn't compose cleanly here.
 *  - CyclicBarrier:             synchronises threads AT a barrier (both arrive, then both
 *                               continue together); the semantics here require sequential
 *                               hand-off, not a rendezvous.
 */
public class M_FoobarAlternate {
    private int n;

    // fooSem(1) → foo thread may proceed immediately on the first iteration
    // barSem(0) → bar thread must block until foo hands off the token
    private Semaphore fooSem = new Semaphore(1);
    private Semaphore barSem = new Semaphore(0);

    public M_FoobarAlternate(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSem.acquire();          // wait for the token (starts at 1, so first call is free)
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSem.release();          // hand the token to bar — bar's acquire() will now unblock
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSem.acquire();          // block until foo hands the token over
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSem.release();          // hand the token back to foo for the next iteration
        }
    }
}
