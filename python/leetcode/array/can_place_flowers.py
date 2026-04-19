class E_CanPlaceFlowers:
    """
    LC: 605
    Tags: Greedy
    https://leetcode.com/problems/can-place-flowers
    You have a long flowerbed in which some of the plots are planted,
    and some are not. However, flowers cannot be planted in adjacent plots.

    Given an integer array flowerbed containing 0's and 1's, where 0 means
    empty and 1 means not empty, and an integer n, return true if n new flowers
    can be planted in the flowerbed without violating the no-adjacent-flowers
    rule and false otherwise.

    Approach:
    Check the left and right of every empty plot. If both neighbors are empty
    or outside the boundary, plant there and decrement n.
    """

    def can_place_flowers(self, flowerbed, n):
        for i in range(len(flowerbed)):
            if flowerbed[i] == 0:
                left = i == 0 or flowerbed[i - 1] == 0
                right = i == len(flowerbed) - 1 or flowerbed[i + 1] == 0
                if left and right:
                    flowerbed[i] = 1
                    n -= 1
        return n <= 0

