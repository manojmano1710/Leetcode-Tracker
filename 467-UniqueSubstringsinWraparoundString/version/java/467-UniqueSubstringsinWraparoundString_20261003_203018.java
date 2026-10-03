// Last updated: 03/10/2026, 20:30:18
1 
2 class Solution {
3    public int findSubstringInWraproundString(String p) {
4        int[] dp= new int[26];
5        int continious=0;
6        for(int i=0;i<p.length();i++){
7            if(i>0 && ( p.charAt(i)-p.charAt(i-1)==1 || p.charAt(i-1)-p.charAt(i)==25)){
8                continious++;
9            }
10            else{
11                continious=1;
12            }
13            int index=p.charAt(i)-'a';
14            dp[index]=Math.max(dp[index],continious);
15        }
16        
17        int ans=0;
18        for(int i: dp){
19            ans+=i;
20        }
21        
22        return ans;
23    }
24}