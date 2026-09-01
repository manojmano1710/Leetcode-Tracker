// Last updated: 01/09/2026, 15:08:31
1class Solution {
2public:
3    bool isPowerOfFour(int n) {
4
5        if (n <= 0)
6            return false;
7
8        while (n % 4 == 0) {
9            n /= 4;
10        }
11
12        return n == 1;
13    }
14};