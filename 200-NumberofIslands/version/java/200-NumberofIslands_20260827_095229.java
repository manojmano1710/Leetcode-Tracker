// Last updated: 27/08/2026, 09:52:29
1class Solution {
2
3    public boolean isIsomorphic(String s, String t) {
4
5        int[] mapST = new int[256];
6        int[] mapTS = new int[256];
7
8        for (int i = 0; i < s.length(); i++) {
9
10            char c1 = s.charAt(i);
11            char c2 = t.charAt(i);
12
13            // s -> t
14            if (mapST[c1] != 0) {
15                if (mapST[c1] != c2) {
16                    return false;
17                }
18            }
19
20            // t -> s
21            if (mapTS[c2] != 0) {
22                if (mapTS[c2] != c1) {
23                    return false;
24                }
25            }
26
27            mapST[c1] = c2;
28            mapTS[c2] = c1;
29        }
30
31        return true;
32    }
33}