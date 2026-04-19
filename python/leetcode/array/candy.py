class H_Candy:
    """
    LC: 135
    https://leetcode.com/problems/candy
    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.

    Approach: First give everyone 1 candy each. Traverse left to right, then right to left,
    updating candies according to the neighbor ratings.

    Tags: Greedy
    """

    def candy(self, ratings):
        n = len(ratings)
        if n == 0:
            return 0

        candies = [1] * n
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1

        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)

        return sum(candies)

