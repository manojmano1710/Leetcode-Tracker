// Last updated: 25/09/2026, 20:12:12
1class Solution {
2    public String addStrings(String num1, String num2) {
3        StringBuilder str = new StringBuilder();
4
5        int i = num1.length() - 1, j = num2.length() - 1, carry = 0, sum;
6
7        while (i >= 0 || j >= 0 || carry > 0) {
8            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
9            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
10
11            sum = digit1 + digit2 + carry;
12            str.append(sum % 10);
13            carry = sum / 10;
14        }
15
16        return str.reverse().toString();
17    }
18}