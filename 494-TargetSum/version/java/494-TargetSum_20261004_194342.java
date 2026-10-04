// Last updated: 04/10/2026, 19:43:42
1class Solution {
2    public int findTargetSumWays(int[] nums, int target) {
3        return helper(nums, target, 0, 0);
4    }
5
6    private int helper(int[] arr, int target, int idx, int sum) {
7        if (idx >= arr.length)
8            return sum == target ? 1 : 0;
9        
10        int subtract = helper(arr, target, idx + 1, sum - arr[idx]);
11        int add = helper(arr, target, idx + 1, sum + arr[idx]);
12
13        return subtract + add;
14    }
15}