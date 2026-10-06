// Last updated: 06/10/2026, 08:54:18
1class Solution {
2    public int minAddToMakeValid(String s) {
3        int count = 0;
4        int result = 0;
5
6        for (char ch : s.toCharArray()) {
7
8            if (ch == '(') {
9                count++;
10            } else {
11                if (count > 0) {
12                    count--;
13                } else {
14                    result++;
15                }
16            }
17        }
18
19        return result + count;
20    }
21}