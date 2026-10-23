// Last updated: 23/10/2026, 19:36:51
1class Solution {
2    public int sortPermutation(int[] nums) {
3        int ans = -1;
4        for (int i = 0; i < nums.length; i++) {
5            if (nums[i] != i) {
6                if (ans == -1) ans = nums[i];
7                else ans &= nums[i];
8            }
9        }
10        return ans == -1 ? 0 : ans;
11    }
12}