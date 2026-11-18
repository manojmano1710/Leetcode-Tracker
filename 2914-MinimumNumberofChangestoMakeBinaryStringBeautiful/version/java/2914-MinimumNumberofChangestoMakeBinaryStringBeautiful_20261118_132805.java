// Last updated: 18/11/2026, 13:28:05
1class Solution {
2    public int minChanges(String s) {
3        int changes = 0;
4        for (int i = 0; i < s.length(); i += 2) {
5            if (s.charAt(i) != s.charAt(i + 1)) {
6                changes++;
7            }
8        }
9        return changes;
10    }
11}