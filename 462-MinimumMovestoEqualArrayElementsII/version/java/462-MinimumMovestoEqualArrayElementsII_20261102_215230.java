// Last updated: 02/11/2026, 21:52:30
1class Solution {
2    public int minMoves2(int[] nums) {
3        Arrays.sort(nums);
4
5        int median = nums[nums.length / 2];
6        int count = 0;
7
8        for (int num : nums) {
9            count += Math.abs(num - median);
10        }
11
12        return count;
13    }
14}