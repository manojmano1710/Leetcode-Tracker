// Last updated: 29/09/2026, 09:27:15
1
2class Solution {
3    public List<Integer> findDuplicates(int[] nums) {
4        List<Integer> ans = new ArrayList<>();
5        int n = nums.length;
6        for (int i = 0; i < n; i++) {
7            int x = Math.abs(nums[i]);
8            if (nums[x - 1] < 0) {
9                ans.add(x);
10            }
11            nums[x - 1] *= -1;
12        }
13        return ans;
14    }
15}