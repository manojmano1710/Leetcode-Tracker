// Last updated: 02/10/2026, 22:39:03
1class Solution {
2    public boolean find132pattern(int[] nums) {
3        Stack<int[]> st = new Stack<>();
4        int cur_min = nums[0];
5
6        for (int i = 1; i < nums.length; i++) {
7            int n = nums[i];
8            while (!st.isEmpty() && n >= st.peek()[0]) {
9                st.pop();
10        }
11
12            if (!st.isEmpty() && n > st.peek()[1]) {
13                return true;
14            }
15
16            st.push(new int[] { n, cur_min });
17            cur_min = Math.min(cur_min, n);
18        }
19
20        return false;        
21    }
22}