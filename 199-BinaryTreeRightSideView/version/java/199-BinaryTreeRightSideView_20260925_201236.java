// Last updated: 25/09/2026, 20:12:36
1class Solution {
2    public boolean canPartition(int[] nums) {
3        int n = nums.length;
4        int sum=0;
5        for(int num:nums){
6            sum+=num;
7        }
8        if(sum%2!=0) return false;
9        int target = sum/2;
10        boolean [] dp = new boolean[target+1];
11        dp[0] = true;
12        for(int num:nums){
13            for(int j=target;j>=num;j--){
14                dp[j] = dp[j]||dp[j-num];
15            }
16        }
17        return dp[target];
18    }
19}