package leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 Tags: Greedy
 https://leetcode.com/problems/queue-reconstruction-by-height
 You are given an array of people, people, which are the attributes of some
 people in a queue (not necessarily in order). Each people[i] = [hi, ki]
 represents the ith person of height hi with exactly ki other people in
 front who have a height greater than or equal to hi.

 Reconstruct and return the queue that is represented by the input array people.
 The returned queue should be formatted as an array queue, where queue[j] = [hj, kj]
 is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).



 Example 1:

 Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 Explanation:
 Person 0 has height 5 with no other people taller or the same height in front.
 Person 1 has height 7 with no other people taller or the same height in front.
 Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
 Person 3 has height 6 with one person taller or the same height in front, which is person 1.
 Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
 Person 5 has height 7 with one person taller or the same height in front, which is person 1.
 Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.



 Approach:
 First we sort the input elemets, descending by height and ascending by k
 After the taller people are inserted, adding smaller people in front or behind of
 them doesnt matter. So We first add the tall people in order of their k,
 then add the shorter people
 */

public class M_406_QueueBuildWithHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a, b) -> {
            if(a[0]!=b[0]){
                return b[0]-a[0];
            } else {
                return a[1]-b[1];
            }
        });

        List<int[]> result = new LinkedList<>();

        for(int[] person:people){
            result.add(person[1],person);
        }

        return result.toArray(new int[people.length][2]);
    }
}
