// Last updated: 27/08/2026, 10:22:44
1class Solution {
2    public int calculate(String s) {
3        int result = 0;
4        int last = 0;
5        int num = 0;
6        char op = '+';
7
8        for (int i = 0; i < s.length(); i++) {
9            char c = s.charAt(i);
10
11            if (Character.isDigit(c)) {
12                num = num * 10 + (c - '0');
13            }
14
15            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
16
17                if (op == '+') {
18                    result += last;
19                    last = num;
20                } 
21                else if (op == '-') {
22                    result += last;
23                    last = -num;
24                } 
25                else if (op == '*') {
26                    last = last * num;
27                } 
28                else if (op == '/') {
29                    last = last / num;
30                }
31
32                op = c;
33                num = 0;
34            }
35        }
36
37        result += last;
38        return result;
39    }
40}