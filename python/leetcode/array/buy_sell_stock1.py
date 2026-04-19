class E_BuySellStock1:
    """
    LC: 121
    Tags: Greedy
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
    in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    Approach:
    Track the minimum buying price seen so far and update the best profit at each step.
    """

    def max_profit(self, prices):
        if not prices:
            return 0

        buy_price = prices[0]
        profit = 0

        for price in prices[1:]:
            if price < buy_price:
                buy_price = price
            profit = max(profit, price - buy_price)

        return profit

