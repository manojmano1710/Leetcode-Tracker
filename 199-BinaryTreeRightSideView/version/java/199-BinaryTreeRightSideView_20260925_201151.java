// Last updated: 25/09/2026, 20:11:51
1class Solution {
2    public int thirdMax(int[] nums) {
3        long max1=Long.MIN_VALUE;
4        long max2=Long.MIN_VALUE;
5        long max3=Long.MIN_VALUE;
6        for(int num : nums){
7            if(num>max1){
8                max3 = max2;
9                max2 = max1;
10                max1 = num;
11            }else if(max1>num && num>max2){
12                max3 = max2;
13                max2 = num;
14            }else if(max2>num && num>max3){
15                max3=num;
16            }
17        }
18        return max3 != Long.MIN_VALUE ? (int) max3 : (int) max1;
19    }
20}