// Last updated: 13/07/2026, 12:39:08
1class Solution {
2    public int maxProfit(int[] prices) {
3        int profit = 0;
4
5        for (int i = 1; i < prices.length; i++) {
6            if (prices[i] > prices[i - 1]) {
7                profit += prices[i] - prices[i - 1];
8            }
9        }
10
11        return profit;
12    }
13}