// Last updated: 09/10/2026, 09:03:46
1class Solution {
2    public int minInsertions(String s) {
3        int insertions = 0;
4        int rightNeeded = 0;
5
6        for (int i = 0; i < s.length(); i++) {
7            char c = s.charAt(i);
8
9            if (c == '(') {
10                if (rightNeeded % 2 != 0) {
11                    insertions++;
12                    rightNeeded--;
13                }
14
15                rightNeeded += 2;
16            } else {
17                rightNeeded--;
18
19                if (rightNeeded < 0) {
20                    insertions++;
21                    rightNeeded += 2;
22                }
23            }
24        }
25
26        return insertions + rightNeeded;
27    }
28}