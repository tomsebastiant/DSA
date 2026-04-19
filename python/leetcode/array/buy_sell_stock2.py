class M_BuySellStock2:
    """
    LC: 122
    Tags: Greedy
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of
    the stock at any time. However, you can buy it then immediately sell it on the same day.

    Find and return the maximum profit you can achieve.

    Approach: Capture every upward price movement.
    """

    def max_profit(self, prices):
        profit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                profit += prices[i] - prices[i - 1]
        return profit

