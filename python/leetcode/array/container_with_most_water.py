class M_ContainerWithMostWater:
    """
    LC: 11
    Tags: TwoPointer
    Tags: Greedy
    Tags: Array
    https://leetcode.com/problems/container-with-most-water
    You are given an integer array height of length n. There are n vertical lines drawn such
    that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container
    contains the most water.

    Approach: Use two pointers from both ends and move the shorter wall inward.
    """

    def max_area(self, height):
        l = 0
        r = len(height) - 1
        max_water = 0
        while l < r:
            if height[l] < height[r]:
                max_water = max(max_water, height[l] * (r - l))
                l += 1
            else:
                max_water = max(max_water, height[r] * (r - l))
                r -= 1
        return max_water

