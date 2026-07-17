// Last updated: 17/07/2026, 10:30:55
1import java.util.*;
2
3class Solution {
4    public int minimumTotal(List<List<Integer>> triangle) {
5
6        int n = triangle.size();
7
8        int[] dp = new int[n + 1];
9
10        for (int i = n - 1; i >= 0; i--) {
11
12            for (int j = 0; j <= i; j++) {
13
14                dp[j] = triangle.get(i).get(j) +
15                        Math.min(dp[j], dp[j + 1]);
16            }
17        }
18
19        return dp[0];
20    }
21}