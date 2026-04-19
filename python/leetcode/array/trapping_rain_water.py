class H_TrappingRainWater:
    """
    LC: 42
    Tags: TwoPointer
    Tags: Array
    https://leetcode.com/problems/trapping-rain-water
    Given n non-negative integers representing an elevation map where the
    width of each bar is 1, compute how much water it can trap after raining.

    Approach: Use two pointers and track the best boundary seen from the left and right.
    Move the side with the smaller boundary inward and accumulate trapped water.
    """

    def trap(self, height):
        if not height:
            return 0

        water = 0
        l = 0
        r = len(height) - 1
        left_max = height[l]
        right_max = height[r]

        while l < r:
            if left_max < right_max:
                l += 1
                left_max = max(left_max, height[l])
                water += left_max - height[l]
            else:
                r -= 1
                right_max = max(right_max, height[r])
                water += right_max - height[r]
        return water

