package problems.greedy;

import java.util.Arrays;

/**
 * LC: 1024
 * Tags: Greedy
 * Tags: Array
 * https://leetcode.com/problems/video-stitching/
 * You are given a series of video clips from a sporting event that lasted time seconds. Each clip
 * is described by clips[i] = [start_i, end_i]. Return the minimum number of clips needed to cover
 * the entire interval [0, time]. Clips may overlap and can be trimmed. Return -1 if impossible.
 *
 * Constraints:
 * 1 <= clips.length <= 100
 * 0 <= start_i <= end_i <= 100
 * 1 <= time <= 100
 *
 * Example 1:
 *
 * Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
 * Output: 3
 * Explanation: Choose [0,2], [1,9], [8,10] → covers [0,2] + [1,9] + [8,10] = [0,10]
 *
 * Example 2:
 *
 * Input: clips = [[0,1],[1,2]], time = 5
 * Output: -1
 * Explanation: Even using both clips we only reach second 2, cannot cover [0,5].
 *
 * Approach: Sort clips by start time. Use a two-tier greedy loop: the outer loop marks each
 * forced clip selection; the inner loop scans all clips starting within the current frontier
 * and tracks the farthest reachable end. Advance the frontier to that max each round.
 * If max never moves forward (gap detected), return -1.
 */
public class M_VideoStitching {
        public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(a,b)->(a[0]-b[0]));

        int curr=0;
        int n=clips.length;
        int i=0;
        int count=0;
        while(curr<time && i<n){
            int max=curr; // farthest end reachable from any clip starting within curr
            while(i<n && clips[i][0]<=curr){ // consume all clips reachable from current frontier
                max = Math.max(max,clips[i][1]);
                i++;
            }
            // if max didn't advance, no clip bridges the gap — will return -1 after loop
            if (max == curr) return -1; 
            curr=max;
            count++;
        }
        if(curr<time) return -1;
        return count;
    }
}
