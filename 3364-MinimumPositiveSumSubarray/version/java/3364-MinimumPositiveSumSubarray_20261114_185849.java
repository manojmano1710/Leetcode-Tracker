// Last updated: 14/11/2026, 18:58:49
1
2class Solution {
3    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
4        int n = nums.size();
5        int[] a = new int[n + 1];
6
7        for (int i = 1; i <= n; i++)
8            a[i] = nums.get(i - 1) + a[i - 1];
9
10        int min = Integer.MAX_VALUE;
11
12        for (int i = l; i <= n; i++) {
13            for (int j = Math.max(0, i - r); j <= i - l; j++) {
14                int sum = a[i] - a[j];
15
16                if (sum > 0)
17                    min = Math.min(min, sum);
18            }
19        }
20
21        return min == Integer.MAX_VALUE ? -1 : min;
22    }
23}