class M_TwoSum2:
    """
    LC: 167
    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2].

    Approach: Use two pointers from both ends and move inward based on the sum.
    Tags: TwoPointer
    Tags: Array
    """

    def two_sum(self, numbers, target):
        l = 0
        r = len(numbers) - 1
        while l < r:
            s = numbers[l] + numbers[r]
            if s > target:
                r -= 1
            elif s < target:
                l += 1
            else:
                break
        return [l + 1, r + 1]

