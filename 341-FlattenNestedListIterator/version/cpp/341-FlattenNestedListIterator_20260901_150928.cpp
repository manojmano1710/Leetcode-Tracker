// Last updated: 01/09/2026, 15:09:28
1class Solution {
2public:
3    int integerBreak(int n) {
4
5        vector<int> dp(n + 1, 0);
6
7        dp[1] = 1;
8
9        for (int i = 2; i <= n; i++) {
10
11            for (int j = 1; j < i; j++) {
12
13                dp[i] = max(
14                    dp[i],
15                    max(
16                        j * (i - j),
17                        j * dp[i - j]
18                    )
19                );
20            }
21        }
22
23        return dp[n];
24    }
25};