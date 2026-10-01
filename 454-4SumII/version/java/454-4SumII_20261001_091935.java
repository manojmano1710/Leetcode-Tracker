// Last updated: 01/10/2026, 09:19:35
1class Solution {
2    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
3        int res = 0;
4        Map<Integer, Integer> map = new HashMap<>();
5        for(int a: nums1) {
6            for(int b: nums2) {
7                map.put(a+b, map.getOrDefault(a+b, 0)+1);
8            }
9        }
10
11        for(int c: nums3) {
12            for(int d: nums4) {
13                res += map.getOrDefault(-(c+d), 0);
14            }
15        }
16        return res;
17    }
18}