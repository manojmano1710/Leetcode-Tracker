// Last updated: 02/09/2026, 09:30:03
1class Solution {
2    public String countAndSay(int n) {
3        String result = "1";
4
5        for (int iteration = 2; iteration <= n; iteration++) {
6            StringBuilder next = new StringBuilder();
7            int index = 0;
8
9            while (index < result.length()) {
10                char currentChar = result.charAt(index);
11                int count = 0;
12
13                while (index < result.length() && result.charAt(index) == currentChar) {
14                    count++;
15                    index++;
16                }
17
18                next.append(count).append(currentChar);
19            }
20
21            result = next.toString();
22        }
23
24        return result;
25    }
26}