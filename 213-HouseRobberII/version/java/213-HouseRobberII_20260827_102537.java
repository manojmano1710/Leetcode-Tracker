// Last updated: 27/08/2026, 10:25:37
1class Solution {
2    public boolean isPowerOfTwo(int n) {
3        return n > 0 && (n & (n - 1)) == 0;
4    }
5}