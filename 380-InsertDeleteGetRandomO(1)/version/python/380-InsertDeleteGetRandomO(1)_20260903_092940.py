# Last updated: 03/09/2026, 09:29:40
1class Solution(object):
2    def lexicalOrder(self, n):
3        """
4        :type n: int
5        :rtype: List[int]
6        """
7        result = []
8        current = 1
9
10        for _ in range(n):
11            result.append(current)
12            if current * 10 <= n:
13                current *= 10  # Go deeper in lexicographical tree
14            else:
15                if current >= n:
16                    current //= 10  # Go back up if out of range
17                current += 1
18                while current % 10 == 0:
19                    current //= 10  # Skip trailing zeros
20
21        return result