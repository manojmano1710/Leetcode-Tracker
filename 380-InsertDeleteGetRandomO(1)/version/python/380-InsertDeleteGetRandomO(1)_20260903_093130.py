# Last updated: 03/09/2026, 09:31:30
1class Solution(object):
2    def lengthLongestPath(self, input):
3        lines = input.split('\n')
4        d = {0: 0}
5        ans = 0
6        for line in lines:
7            level = line.count('\t')
8            name = line.lstrip('\t')
9            if '.' in name:
10                ans = max(ans, d[level] + len(name))
11            else:
12                d[level + 1] = d[level] + len(name) + 1
13        return ans