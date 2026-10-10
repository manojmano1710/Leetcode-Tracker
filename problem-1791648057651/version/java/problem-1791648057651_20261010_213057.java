// Last updated: 10/10/2026, 21:30:57
1class Solution {
2    public int[] maxProductPair(int[] nums, int target) {
3        int max = Integer.MIN_VALUE;
4        int[] ans = {-1,-1};
5        for(int i =0; i<nums.length;i++){
6            for(int j=0; j<nums.length;j++){
7                if(i != j && nums[i] + nums[j] == target && nums[i] > nums[j]) {
8                    int product = nums[i] * nums[j];
9                    if(product > max){
10                        max = product;
11                        ans[0]=i;
12                        ans[1]=j;
13                    }
14                }
15            }
16        }
17        return ans;
18    }
19}