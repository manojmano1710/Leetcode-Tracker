// Last updated: 17/07/2026, 10:16:45
1import java.util.*;
2
3class Solution {
4    public boolean wordBreak(String s, List<String> wordDict) {
5
6        Set<String> set = new HashSet<>(wordDict);
7
8        boolean[] dp = new boolean[s.length() + 1];
9
10        dp[0] = true;
11
12        for (int i = 1; i <= s.length(); i++) {
13
14            for (int j = 0; j < i; j++) {
15
16                if (dp[j] && set.contains(s.substring(j, i))) {
17                    dp[i] = true;
18                    break;
19                }
20            }
21        }
22
23        return dp[s.length()];
24    }
25}