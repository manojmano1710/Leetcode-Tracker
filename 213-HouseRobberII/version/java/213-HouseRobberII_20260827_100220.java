// Last updated: 27/08/2026, 10:02:20
1class Solution {
2    public String shortestPalindrome(String s) {
3
4        if (s.length() <= 1) {
5            return s;
6        }
7
8        String rev = new StringBuilder(s).reverse().toString();
9
10        String combined = s + "#" + rev;
11
12        int[] lps = new int[combined.length()];
13
14        int i = 1;
15        int len = 0;
16
17        while (i < combined.length()) {
18
19            if (combined.charAt(i) == combined.charAt(len)) {
20                len++;
21                lps[i] = len;
22                i++;
23            } else if (len > 0) {
24                len = lps[len - 1];
25            } else {
26                lps[i] = 0;
27                i++;
28            }
29        }
30
31        int longestPrefix = lps[combined.length() - 1];
32
33        String remaining = s.substring(longestPrefix);
34
35        String add = new StringBuilder(remaining)
36                .reverse()
37                .toString();
38
39        return add + s;
40    }
41}