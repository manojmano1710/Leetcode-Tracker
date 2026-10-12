// Last updated: 12/10/2026, 19:30:02
1class Solution {
2    public int maxSum(List<Integer> nums, int k) {
3        final long MOD = 1_000_000_007L;
4        int[] bits = new int[31];
5
6        for (int x : nums)
7            for (int b = 0; b < 31; b++)
8                if ((x & (1 << b)) != 0)
9                    bits[b]++;
10
11        long ans = 0;
12
13        while (k-- > 0) {
14            long x = 0;
15
16            for (int b = 0; b < 31; b++)
17                if (bits[b] > 0) {
18                    x |= 1L << b;
19                    bits[b]--;
20                }
21
22            ans = (ans + x * x) % MOD;
23        }
24
25        return (int) ans;
26    }
27}