// Last updated: 27/08/2026, 10:17:54
1class Solution {
2
3    public int maximalSquare(char[][] matrix) {
4
5        int rows = matrix.length;
6        int cols = matrix[0].length;
7
8        int[][] dp = new int[rows + 1][cols + 1];
9
10        int maxSide = 0;
11
12        for (int i = 1; i <= rows; i++) {
13
14            for (int j = 1; j <= cols; j++) {
15
16                if (matrix[i - 1][j - 1] == '1') {
17
18                    dp[i][j] = 1 + Math.min(
19                        dp[i - 1][j],
20                        Math.min(
21                            dp[i][j - 1],
22                            dp[i - 1][j - 1]
23                        )
24                    );
25
26                    maxSide = Math.max(maxSide, dp[i][j]);
27                }
28            }
29        }
30
31        return maxSide * maxSide;
32    }
33}