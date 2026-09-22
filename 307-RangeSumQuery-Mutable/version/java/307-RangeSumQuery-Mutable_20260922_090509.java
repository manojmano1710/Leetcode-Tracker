// Last updated: 22/09/2026, 09:05:09
1class Solution {
2    public int maxProfit(int[] prices) {
3        int len = prices.length;
4        if (len < 2) return 0;
5        int[] sell = new int[len];
6        int[] buy  = new int[len];
7
8        buy[0]  = -prices[0];
9        buy[1]  = -Math.min(prices[0], prices[1]);
10        sell[1] = Math.max(0, buy[0] + prices[1]);
11
12        for (int i = 2; i < len; i++){
13            buy[i]  = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
14            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
15        }
16        return sell[len - 1];
17    }
18}