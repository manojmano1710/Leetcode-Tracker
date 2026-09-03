// Last updated: 03/09/2026, 09:28:43
1/**
2 * // This is the interface that allows for creating nested lists.
3 * // You should not implement it, or speculate about its implementation
4 * public interface NestedInteger {
5 *     public NestedInteger();
6 *     public NestedInteger(int value);
7 *     public boolean isInteger();
8 *     public Integer getInteger();
9 *     public void setInteger(int value);
10 *     public void add(NestedInteger ni);
11 *     public List<NestedInteger> getList();
12 * }
13 */
14
15class Solution {
16
17    public NestedInteger deserialize(String s) {
18
19        NestedInteger ns = new NestedInteger();
20
21        int n = s.length();
22        int i = 0;
23
24        // Whether current object represents a list
25        boolean isList = false;
26
27        // Ignore the outer closing bracket if this is a list
28        int t = n;
29
30        if (s.charAt(i) == '[') {
31            isList = true;
32            i++;
33            t--;
34        }
35
36        StringBuilder sb = new StringBuilder();
37
38        while (i < t) {
39
40            char c = s.charAt(i);
41
42            // Build the current integer
43            if (Character.isDigit(c) || c == '-') {
44                sb.append(c);
45                i++;
46            }
47
48            // Integer completed
49            else if (c == ',') {
50
51                isList = true;
52
53                if (sb.length() != 0) {
54                    ns.add(new NestedInteger(Integer.parseInt(sb.toString())));
55                }
56
57                sb = new StringBuilder();
58                i++;
59            }
60
61            // Nested list starts
62            else if (c == '[') {
63
64                isList = true;
65
66                int count = 1;
67                sb.append(c);
68                i++;
69
70                // Find the matching closing bracket
71                while (count != 0 && i < t) {
72
73                    c = s.charAt(i);
74                    sb.append(c);
75
76                    if (c == '[')
77                        count++;
78                    else if (c == ']')
79                        count--;
80
81                    i++;
82                }
83
84                // Recursively deserialize the nested list
85                ns.add(deserialize(sb.toString()));
86
87                sb = new StringBuilder();
88            }
89        }
90
91        // Process the final number (if any)
92        if (sb.length() != 0) {
93
94            if (isList)
95                ns.add(new NestedInteger(Integer.parseInt(sb.toString())));
96            else
97                ns.setInteger(Integer.parseInt(sb.toString()));
98        }
99
100        return ns;
101    }
102}