// Last updated: 01/09/2026, 09:52:54
1class Solution {
2public:
3
4    // Add two non-negative numbers represented as strings
5    string add(string a, string b) {
6        int i = a.size() - 1;
7        int j = b.size() - 1;
8        int carry = 0;
9
10        string res;
11
12        while (i >= 0 || j >= 0 || carry) {
13            int sum = carry;
14
15            if (i >= 0)
16                sum += a[i--] - '0';
17
18            if (j >= 0)
19                sum += b[j--] - '0';
20
21            res.push_back((sum % 10) + '0');
22            carry = sum / 10;
23        }
24
25        reverse(res.begin(), res.end());
26        return res;
27    }
28
29    // Check whether the remaining string follows the additive sequence
30    bool check(string a, string b, string& num, int pos) {
31
32        while (pos < num.size()) {
33
34            string sum = add(a, b);
35
36            // Not enough characters left
37            if (pos + sum.size() > num.size())
38                return false;
39
40            // Next number must exactly match the sum
41            if (num.substr(pos, sum.size()) != sum)
42                return false;
43
44            pos += sum.size();
45
46            a = b;
47            b = sum;
48        }
49
50        return true;
51    }
52
53    bool isAdditiveNumber(string num) {
54
55        int n = num.size();
56
57        // Choose first number
58        for (int i = 1; i <= n - 2; i++) {
59
60            // Leading zero is not allowed
61            if (num[0] == '0' && i > 1)
62                break;
63
64            string a = num.substr(0, i);
65
66            // Choose second number
67            for (int j = i + 1; j <= n - 1; j++) {
68
69                // Leading zero is not allowed
70                if (num[i] == '0' && j - i > 1)
71                    break;
72
73                string b = num.substr(i, j - i);
74
75                if (check(a, b, num, j))
76                    return true;
77            }
78        }
79
80        return false;
81    }
82};