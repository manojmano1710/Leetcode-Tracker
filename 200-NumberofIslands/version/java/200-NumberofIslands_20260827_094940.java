// Last updated: 27/08/2026, 09:49:40
1import java.util.HashSet;
2
3class Solution {
4
5    public boolean isHappy(int n) {
6
7        HashSet<Integer> set = new HashSet<>();
8
9        while (n != 1) {
10
11            if (set.contains(n)) {
12                return false;
13            }
14
15            set.add(n);
16
17            n = sumOfSquares(n);
18        }
19
20        return true;
21    }
22
23    private int sumOfSquares(int n) {
24
25        int sum = 0;
26
27        while (n > 0) {
28
29            int digit = n % 10;
30
31            sum += digit * digit;
32
33            n /= 10;
34        }
35
36        return sum;
37    }
38}