// Last updated: 03/09/2026, 09:32:17
1class Solution {
2    public char findTheDifference(String s, String t) {
3        char c = 0;
4        for(char cs : s.toCharArray()) c ^= cs;
5        for(char ct : t.toCharArray()) c ^= ct;
6        return c;
7    }
8}