package problems.binarysearch;

/**
 * LC: 410
 * Tags: Array
 * Tags: BinarySearch
 * Tags: Greedy
 * https://leetcode.com/problems/split-array-largest-sum/
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that
 * the largest sum of any subarray is minimized.
 *
 * Return the minimized largest sum of the split.
 *
 * Example 1:
 *
 * Input: nums = [7,2,5,10,8], k = 2
 * Output: 18
 * Explanation: The best split is [7,2,5] and [10,8], where the largest subarray sum is 18.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], k = 2
 * Output: 9
 *
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 10^6
 * 1 <= k <= min(50, nums.length)
 *
 * Approach: Binary search on the answer space rather than on the array. The minimum possible
 * largest-subarray-sum is max(nums) (every element must fit in some subarray) and the maximum is
 * sum(nums) (one subarray holding everything). For each candidate limit mid, a greedy check counts
 * the fewest subarrays needed so no subarray exceeds mid â€” if that count is <= k the limit is
 * feasible and we search lower; otherwise we search higher. When the loop ends, low is the smallest
 * feasible limit.
 */
public class H_CanSplitMinSum {
        public int splitArray(int[] nums, int k) {
        // low: smallest possible answer â€” every element must fit, so max element is the floor.
        // high: largest possible answer â€” one subarray with everything.
        int low=0;
        int high=0;

        for(int num:nums){
            low=Math.max(low,num);
            high=high+num;
        }

        while(low<=high){
            int mid = low+(high-low)/2;

            if(canSplit(nums,k,mid)){
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        // low is the first value where canSplit returns true â€” the minimum feasible limit.
        return low;
    }

    public boolean canSplit(int[] nums, int k, int limit){
        int curr=0;
        int splits=1;
        for(int num:nums){
            if(num+curr>limit){
                // Current element can't fit â€” start a new subarray with it as the first element.
                splits++;
                if(splits>k) return false;
                curr=num;
            } else {
                curr=curr+num;
            }
        }
        return true;
    }
}

