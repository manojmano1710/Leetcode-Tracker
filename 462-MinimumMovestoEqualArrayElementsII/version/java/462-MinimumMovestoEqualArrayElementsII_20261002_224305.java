// Last updated: 02/10/2026, 22:43:05
1class Solution {
2    public int minMoves2(int[] nums) {
3        Arrays.sort(nums);
4        int ans = 0, median = nums[nums.length / 2];
5        for (int num : nums) ans += Math.abs(median - num);
6        return ans;
7    }
8}