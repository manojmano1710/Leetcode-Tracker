// Last updated: 25/09/2026, 20:09:37
1class Solution {
2
3    public int rob(int[] nums) {
4
5        int prv2 = 0;
6        int prv = nums[0];
7        int cur = 0;
8
9        for(int i = 1; i < nums.length; i++){
10
11            int take = nums[i];
12
13            if(i > 1){
14                take += prv2;
15            }
16
17            int nontake = 0 + prv;
18
19            cur = Math.max(take, nontake);
20
21            prv2 = prv;
22            prv = cur;
23        }
24
25        return prv;
26    }
27}