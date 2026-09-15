// Last updated: 15/09/2026, 14:51:48
1class Solution {
2    public int nthUglyNumber(int n) {
3
4        int[] dp = new int[n + 1];
5
6        int i2 = 1;
7        int i3 = 1;
8        int i5 = 1;
9
10        dp[1] = 1;
11
12        for (int i = 2; i <= n; i++) {
13
14            int next = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
15
16            dp[i] = next;
17
18            if (next == dp[i2] * 2)
19                i2++;
20
21            if (next == dp[i3] * 3)
22                i3++;
23
24            if (next == dp[i5] * 5)
25                i5++;
26        }
27
28        return dp[n];
29    }
30}