package problems.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * LC: 355
 * Tags: Design
 * Tags: PriorityQueue
 * Tags: HashTable
 * https://leetcode.com/problems/design-twitter/
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another
 * user, and see the 10 most recent tweets in the user's news feed.
 *
 * Implement the Twitter class:
 * - Twitter() initializes the object.
 * - void postTweet(int userId, int tweetId) composes a new tweet by userId.
 * - List<Integer> getNewsFeed(int userId) retrieves the 10 most recent tweet IDs from the user
 *   and everyone they follow, ordered most recent first.
 * - void follow(int followerId, int followeeId) followerId starts following followeeId.
 * - void unfollow(int followerId, int followeeId) followerId stops following followeeId.
 *
 * Example 1:
 *
 * Input:  ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
 *         [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
 * Output: [null,null,[5],null,null,[6,5],null,[5]]
 *
 * Constraints:
 * 1 <= userId, followerId, followeeId <= 500
 * 0 <= tweetId <= 10^4
 * All tweet IDs are unique.
 * At most 3 * 10^4 calls will be made in total.
 *
 * Approach: Tweets are stored per-user as a chronological list of [timestamp, tweetId] pairs,
 * where a global counter assigns strictly increasing timestamps. getNewsFeed performs a k-way merge
 * using a max-heap: seed it with the most recent tweet from the user and each followee, then
 * repeatedly pop the newest tweet, add it to the result, and push the next older tweet from that
 * same user. Stop after 10 results. The user is temporarily added to their own followee set to
 * unify the loop, then removed afterward to avoid mutating the stored follow graph.
 */
public class M_Twitter {
    private int timestamp=0;

    // tweetMap: userId -> chronological list of [timestamp, tweetId]
    private Map<Integer,List<int[]>> tweetMap = new HashMap<>();
    // followMap: followerId -> set of followeeIds
    private Map<Integer,Set<Integer>> followMap = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // Max-heap ordered by timestamp so the most recent tweet is always at the front.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        Set<Integer> followees = followMap.getOrDefault(userId,new HashSet<>());

        // Include the user's own tweets without duplicating follow-map logic.
        followees.add(userId);

        for(int fId:followees){
            List<int[]> tweets = tweetMap.get(fId);
            if(tweets!=null && !tweets.isEmpty()){
                int idx=tweets.size()-1;
                int[] latest = tweets.get(idx);
                // Heap entry: [timestamp, tweetId, userId, listIndex] — listIndex lets us walk backward.
                pq.offer(new int[]{latest[0],latest[1],fId,idx});
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!pq.isEmpty() && result.size()<10){
            int[] curr = pq.poll();
            result.add(curr[1]);

            // Push the next older tweet from the same user to continue the k-way merge.
            int nextIdx=curr[3]-1;
            if(nextIdx>=0){
                int[] nextTweet=tweetMap.get(curr[2]).get(nextIdx);
                pq.offer(new int[]{nextTweet[0],nextTweet[1],curr[2],nextIdx});
            }
        }
        // Undo the temporary self-inclusion so the stored follow set is not changed.
        followees.remove(userId);
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k->new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k->new HashSet<>())
            .remove(followeeId);
    }
}
