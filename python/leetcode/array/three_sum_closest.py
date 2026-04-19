class M_3SumClosest:
    """
    LC: 16
    Tags: TwoPointer
    Tags: Array
    https://leetcode.com/problems/3sum-closest
    Given an integer array nums of length n and an integer target, find three
    integers in nums such that the sum is closest to target.

    Return the sum of the three integers.

    Approach: Sort the array, fix one element, and use two pointers on the remainder.
    """

    def three_sum_closest(self, nums, target):
        nums.sort()
        n = len(nums)
        close = nums[0] + nums[1] + nums[-1]

        for i in range(n - 2):
            j = i + 1
            k = n - 1
            while j < k:
                temp = nums[i] + nums[j] + nums[k]
                if temp < target:
                    j += 1
                else:
                    k -= 1
                if abs(target - temp) < abs(target - close):
                    close = temp
        return close

