// Last updated: 21/09/2026, 18:19:10
1class Solution {
2    public int countSegments(String s) {
3        int count = 0;
4        boolean inSegment = false;
5        for (char c : s.toCharArray()) {
6            if (c != ' ' && !inSegment) {
7                count++;
8                inSegment = true;
9            } else if (c == ' ') {
10                inSegment = false;
11            }
12        }
13        return count;
14    }
15}