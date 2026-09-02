// Last updated: 02/09/2026, 09:20:51
1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int start = 0;
4        int end = nums.length-1;
5
6        while (start <= end) {
7            int mid = start + (end-start)/2;
8            if (nums[mid] == target) return mid;
9            else if (nums[mid] > target) end = mid-1;
10            else start = mid+1;
11        }
12
13        return start;
14    }
15}