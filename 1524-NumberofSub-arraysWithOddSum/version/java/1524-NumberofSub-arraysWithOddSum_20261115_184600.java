// Last updated: 15/11/2026, 18:46:00
1class Solution {
2    public int numOfSubarrays(int[] arr) {
3        int n = arr.length;
4        int cntEv = 0;
5        int cntOdd = 0;
6        int pre = 0; int mod = (int)1e9 + 7;
7        int ans = 0;
8        for(int i = 0; i < n;i++){
9            pre += arr[i];
10
11            if((pre&1) == 0){ //so we need to remove subarrays(0...i) having sum as odd to make the resulting subarray odd
12                ans = (ans + cntOdd) % mod;
13                cntEv++;
14            }else{
15                ans = (ans + cntEv) % mod;
16                ans++;
17                cntOdd++;
18            }
19        }
20        return ans;
21    }
22}