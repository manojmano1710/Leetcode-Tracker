// Last updated: 05/11/2026, 22:21:06
1class Solution {
2    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
3        int ans=0;
4        for(int i=0;i<arr1.length;i++){
5            boolean valid=true;
6            for(int j=0;j<arr2.length;j++){
7                if(Math.abs(arr1[i]-arr2[j])<=d){
8                    valid=false;
9                    break;
10                }
11            }
12            if(valid)ans++;
13        }
14        return ans;
15    }
16}