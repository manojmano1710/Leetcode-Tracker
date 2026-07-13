// Last updated: 13/07/2026, 12:34:58
1class Solution {
2    public int mySqrt(int x) {
3        if (x == 0 || x == 1) {
4            return x;
5        }
6
7        int left = 1, right = x, ans = 0;
8
9        while (left <= right) {
10            int mid = left + (right - left) / 2;
11
12            if ((long) mid * mid == x) {
13                return mid;
14            } else if ((long) mid * mid < x) {
15                ans = mid;
16                left = mid + 1;
17            } else {
18                right = mid - 1;
19            }
20        }
21
22        return ans;
23    }
24}