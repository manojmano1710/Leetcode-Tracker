# Last updated: 07/10/2026, 11:47:16
1class Solution:
2    def removeInvalidParentheses(self, s: str) -> List[str]:
3        ans = []
4        self.remove(s, ans, 0, 0, ['(', ')'])
5        return ans
6
7    def remove(self, s, ans, i, j, p):
8        count = 0
9
10        for k in range(i, len(s)):
11            if s[k] == p[0]:
12                count += 1
13            if s[k] == p[1]:
14                count -= 1
15
16            if count < 0:
17                for x in range(j, k + 1):
18                    if s[x] == p[1] and (x == j or s[x - 1] != p[1]):
19                        self.remove(s[:x] + s[x + 1:], ans, k, x, p)
20                return
21
22        rev = s[::-1]
23
24        if p[0] == '(':
25            self.remove(rev, ans, 0, 0, [')', '('])
26        else:
27            ans.append(rev)