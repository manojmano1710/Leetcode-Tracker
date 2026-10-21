// Last updated: 21/10/2026, 18:37:19
1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        boolean sorted = true;
5        for (int i = 1; i < n; ++i) {
6            if (s.charAt(i) < s.charAt(i - 1)) {
7                sorted = false;
8                break;
9            }
10        }
11        if (sorted) return 0;
12        if (n == 2) return -1;
13        char mn = s.charAt(0), mx = s.charAt(0);
14        for (int i = 1; i < n; ++i) {
15            char c = s.charAt(i);
16            if (c < mn) mn = c;
17            if (c > mx) mx = c;
18        }
19        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) return 1;
20        for (int i = 1; i < n - 1; ++i) {
21            char c = s.charAt(i);
22            if (c == mn || c == mx) return 2;
23        }
24        return 3;
25    }
26}