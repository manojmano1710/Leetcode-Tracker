// Last updated: 02/10/2026, 22:41:10
1class Solution {
2    public boolean repeatedSubstringPattern(String s) {
3        int n = s.length(), prevLPS = 0, i = 1;
4        int[] lps = new int[n];
5        while (i < n) {
6            if (s.charAt(i) == s.charAt(prevLPS)) {
7                lps[i++] = ++prevLPS;
8            } else if (prevLPS == 0) {
9                lps[i++] = 0;
10            } else {
11                prevLPS = lps[prevLPS - 1];
12            }
13        }
14        return lps[n - 1] > 0 && n % (n - lps[n - 1]) == 0;
15    }
16}