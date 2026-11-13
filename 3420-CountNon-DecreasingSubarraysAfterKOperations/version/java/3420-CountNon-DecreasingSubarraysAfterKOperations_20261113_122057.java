// Last updated: 13/11/2026, 12:20:57
1class Solution {
2    public long countNonDecreasingSubarrays(int[] nums, int k) {
3        int n = nums.length;
4        int r = n-1;
5        long ans = 0;
6        long change = 0;
7        Deque<int[]> deque = new ArrayDeque<>();
8        for (int l = n-1; l >= 0; l--){
9            int curMin = nums[l];
10            int curMinCount = 1;
11            while (!deque.isEmpty() && deque.peekFirst()[0] <= curMin){
12                int[] pair = deque.pollFirst();
13                curMinCount += pair[1];
14                change += (long)(curMin-pair[0]) * pair[1];
15            }
16            deque.offerFirst(new int[]{curMin, curMinCount});
17            while (change > k){
18                int[] last = deque.peekLast();
19                last[1]--;
20                change -= last[0] - nums[r];
21                r--;
22                if (last[1] == 0) deque.pollLast();
23            }
24            ans += r-l+1;
25        }
26        return ans;
27    }
28}