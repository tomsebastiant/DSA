package problems.binarysearch;

/**
 * LC: 153
 * Tags: Array
 * Tags: BinarySearch
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 *
 * Example 3:
 *
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: No rotation; the minimum is the first element.
 *
 * Approach: Binary search on the rotation boundary. If nums[mid] > nums[r], the minimum lies in
 * the right half (l = mid + 1); otherwise it lies in the left half including mid (r = mid).
 * The search converges when l == r, which points to the minimum.
 */
public class M_MinSortedRotatedArray {
        public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]>nums[r]){
                l=mid+1;
            } else {
                r=mid;
            }
        }
        return nums[l];
    }
}

