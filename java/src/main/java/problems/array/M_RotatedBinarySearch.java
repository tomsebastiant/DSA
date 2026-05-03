package problems.array;

/**
 * LC: 33
 https://leetcode.com/problems/search-in-rotated-sorted-array/
 There is an integer array nums sorted in ascending order with distinct values.
 Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k.
 For example, [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2].
 Given the array nums after the possible rotation and an integer target, return the index of target
 if it is in nums, or -1 if it is not in nums.

 Example 1:
 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4

 Example 2:
 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1

 Approach: Use binary search and determine which half is still sorted on every iteration.
 If the left half is sorted, check whether the target lies inside it; otherwise search the right half.
 Repeat the same logic for the right sorted half.

 Tags: Array
 Tags: BinarySearch
 Tags: Binary Search
 */
public class M_RotatedBinarySearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;

            // Left half is sorted.
            if (nums[l] <= nums[mid]) {
                // Target is inside the sorted left half.
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // Right half is sorted.
                // Target is inside the sorted right half.
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
