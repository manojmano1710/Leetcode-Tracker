// Last updated: 17/11/2026, 19:28:54
1class Solution {
2    public int minimumChanges(String s, int k) {
3        int n = s.length();
4        final int INF = 1000000000;
5
6        List<Integer>[] divisors = new ArrayList[n + 1];
7
8        for (int d = 0; d <= n; d++) {
9            divisors[d] = new ArrayList<>();
10        }
11
12        for (int d = 1; d <= n; d++) {
13            for (int v = 1; v < d; v++) {
14                if (d % v == 0) {
15                    divisors[d].add(v);
16                }
17            }
18        }
19
20        int[][] cost = new int[n + 1][n + 1];
21
22        for (int[] row : cost) {
23            Arrays.fill(row, INF);
24        }
25
26        for (int i = 0; i < n; i++) {
27            for (int j = i + 1; j < n; j++) {
28                int L = j - i + 1;
29                int best = INF;
30
31                for (int d : divisors[L]) {
32                    int changes = 0;
33
34                    for (int start = i; start < i + d; start++) {
35                        int l = start;
36                        int r = start + ((j - start) / d) * d;
37
38                        while (l < r) {
39                            if (s.charAt(l) != s.charAt(r)) {
40                                changes++;
41                            }
42
43                            l += d;
44                            r -= d;
45                        }
46                    }
47
48                    best = Math.min(best, changes);
49                }
50
51                cost[i][j] = best;
52            }
53        }
54
55        int[][] dp = new int[k + 1][n + 1];
56
57        for (int[] row : dp) {
58            Arrays.fill(row, INF);
59        }
60
61        dp[0][0] = 0;
62
63        for (int t = 1; t <= k; t++) {
64            for (int i = t; i <= n; i++) {
65                for (int j = t - 1; j < i; j++) {
66                    if (dp[t - 1][j] < INF &&
67                        cost[j][i - 1] < INF) {
68
69                        dp[t][i] = Math.min(
70                            dp[t][i],
71                            dp[t - 1][j] + cost[j][i - 1]
72                        );
73                    }
74                }
75            }
76        }
77
78        return dp[k][n];
79    }
80}