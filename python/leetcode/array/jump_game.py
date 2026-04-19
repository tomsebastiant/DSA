class M_JumpGame:
    """
    LC: 55
    Tags: Greedy
    https://leetcode.com/problems/jump-game
    You are given an integer array nums. You are initially positioned
    at the array's first index, and each element in the array represents
    your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.

    Approach: Track the farthest reachable index and fail as soon as the current
    position is beyond it.
    """

    def can_jump(self, nums):
        max_reach = nums[0]
        for i in range(1, len(nums)):
            if i <= max_reach:
                max_reach = max(max_reach, i + nums[i])
            else:
                return False
        return True

