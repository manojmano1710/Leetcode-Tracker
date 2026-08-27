// Last updated: 27/08/2026, 09:56:05
1class Solution {
2    public int minSubArrayLen(int target, int[] nums) {
3
4        int left = 0;
5        int sum = 0;
6        int minLength = Integer.MAX_VALUE;
7
8        for (int right = 0; right < nums.length; right++) {
9
10            sum += nums[right];
11
12            while (sum >= target) {
13
14                minLength = Math.min(minLength, right - left + 1);
15
16                sum -= nums[left];
17                left++;
18            }
19        }
20
21        return minLength == Integer.MAX_VALUE ? 0 : minLength;
22    }
23}