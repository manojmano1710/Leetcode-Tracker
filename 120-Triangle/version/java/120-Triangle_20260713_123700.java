// Last updated: 13/07/2026, 12:37:00
1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        int n = triangle.size();
4        int[] dp = new int[n + 1];
5
6        for (int i = n - 1; i >= 0; i--) {
7            for (int j = 0; j <= i; j++) {
8                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
9            }
10        }
11
12        return dp[0];
13    }
14}