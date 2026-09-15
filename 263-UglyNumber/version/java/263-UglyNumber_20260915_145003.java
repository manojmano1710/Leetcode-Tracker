// Last updated: 15/09/2026, 14:50:03
1class Solution {
2    public boolean isUgly(int n) {
3        if (n <= 0)
4            return false;
5
6        if (n % 2 == 0) {
7            return isUgly(n / 2);
8        }
9        if (n % 3 == 0) {
10            return isUgly(n / 3);
11        }
12        if (n % 5 == 0) {
13            return isUgly(n / 5);
14        }
15
16        if (n == 1)
17            return true;
18        else
19            return false;
20    }
21}