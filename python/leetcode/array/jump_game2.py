class M_JumpGame2:
    """
    LC: 45
    Tags: Greedy
    https://leetcode.com/problems/jump-game-ii
    You are given a 0-indexed array of integers nums of length n.
    You are initially positioned at nums[0].

    Return the minimum number of jumps to reach nums[n - 1].

    Approach: Track the farthest reachable position in the current jump window,
    and when the window ends, commit a jump and extend the window.
    """

    def jump(self, nums):
        farthest = 0
        jumps = 0
        current_jump_end = 0
        for i in range(len(nums) - 1):
            farthest = max(farthest, i + nums[i])
            if i == current_jump_end:
                current_jump_end = farthest
                jumps += 1
        return jumps

