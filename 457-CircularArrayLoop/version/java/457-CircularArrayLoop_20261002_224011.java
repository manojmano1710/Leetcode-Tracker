// Last updated: 02/10/2026, 22:40:11
1class Solution {
2    public boolean circularArrayLoop(int[] nums) {
3        int n = nums.length;
4
5        for (int i = 0; i < n; i++) {
6            int slow = i, fast = i;
7            boolean forward = nums[i] > 0;
8
9            while (true) {
10                slow = next(nums, slow);
11                if ((nums[slow] > 0) != forward) break;
12
13                fast = next(nums, fast);
14                if ((nums[fast] > 0) != forward) break;
15
16               fast = next(nums, fast); 
17                if ((nums[fast] > 0) != forward) break;
18
19                if (slow == fast) {
20                    if (slow == next(nums, slow)) break;
21                    return true;
22                }
23            }
24        }
25        return false;
26    }
27
28    private int next(int[] nums, int i) {
29        int n = nums.length;
30        int next = (i + nums[i]) % n;
31        if (next < 0) next += n;
32        return next;
33    }
34}