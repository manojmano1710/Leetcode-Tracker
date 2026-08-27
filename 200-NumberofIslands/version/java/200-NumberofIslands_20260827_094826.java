// Last updated: 27/08/2026, 09:48:26
1class Solution {
2
3    public int rangeBitwiseAnd(int left, int right) {
4
5        int shifts = 0;
6
7        // Find the common binary prefix
8        while (left != right) {
9            left = left >> 1;
10            right = right >> 1;
11            shifts++;
12        }
13
14        // Restore the common prefix
15        return left << shifts;
16    }
17}