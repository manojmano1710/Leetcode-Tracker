// Last updated: 27/08/2026, 10:21:20
1import java.util.*;
2
3class Solution {
4    public int calculate(String s) {
5
6        Stack<Integer> stack = new Stack<>();
7
8        int result = 0;
9        int number = 0;
10        int sign = 1;
11
12        for (int i = 0; i < s.length(); i++) {
13
14            char c = s.charAt(i);
15
16            if (Character.isDigit(c)) {
17
18                number = number * 10 + (c - '0');
19
20            } else if (c == '+') {
21
22                result += sign * number;
23                number = 0;
24                sign = 1;
25
26            } else if (c == '-') {
27
28                result += sign * number;
29                number = 0;
30                sign = -1;
31
32            } else if (c == '(') {
33
34                stack.push(result);
35                stack.push(sign);
36
37                result = 0;
38                sign = 1;
39
40            } else if (c == ')') {
41
42                result += sign * number;
43                number = 0;
44
45                int previousSign = stack.pop();
46                int previousResult = stack.pop();
47
48                result = previousResult + previousSign * result;
49            }
50        }
51
52        result += sign * number;
53
54        return result;
55    }
56}