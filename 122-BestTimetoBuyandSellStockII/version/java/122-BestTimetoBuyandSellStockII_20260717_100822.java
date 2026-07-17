// Last updated: 17/07/2026, 10:08:22
1class Solution {
2    public int minCut(String s) {
3        int n = s.length();
4
5        // palindrome[i][j] = true if s[i...j] is a palindrome
6        boolean[][] palindrome = new boolean[n][n];
7
8        // cuts[i] = minimum cuts needed for s[0...i]
9        int[] cuts = new int[n];
10
11        for (int end = 0; end < n; end++) {
12
13            cuts[end] = end; // Maximum possible cuts
14
15            for (int start = 0; start <= end; start++) {
16
17                if (s.charAt(start) == s.charAt(end) &&
18                        (end - start <= 2 || palindrome[start + 1][end - 1])) {
19
20                    palindrome[start][end] = true;
21
22                    if (start == 0) {
23                        cuts[end] = 0;
24                    } else {
25                        cuts[end] = Math.min(cuts[end], cuts[start - 1] + 1);
26                    }
27                }
28            }
29        }
30
31        return cuts[n - 1];
32    }
33}