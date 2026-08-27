// Last updated: 27/08/2026, 10:01:09
1class Solution {
2    public int rob(int[] nums) {
3
4        if (nums.length == 1) {
5            return nums[0];
6        }
7
8        int case1 = robRange(nums, 0, nums.length - 2);
9        int case2 = robRange(nums, 1, nums.length - 1);
10
11        return Math.max(case1, case2);
12    }
13
14    private int robRange(int[] nums, int start, int end) {
15
16        int prev2 = 0;
17        int prev1 = 0;
18
19        for (int i = start; i <= end; i++) {
20
21            int current = Math.max(
22                prev1,
23                prev2 + nums[i]
24            );
25
26            prev2 = prev1;
27            prev1 = current;
28        }
29
30        return prev1;
31    }
32}