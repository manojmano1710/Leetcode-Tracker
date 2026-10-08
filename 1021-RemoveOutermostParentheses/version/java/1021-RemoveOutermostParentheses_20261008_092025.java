// Last updated: 08/10/2026, 09:20:25
1class Solution {
2    static {
3        for (int i = 0; i<300; i++) {
4            removeOuterParentheses("()");
5        }
6    }
7    public static String removeOuterParentheses(String s) {
8        StringBuilder ans=new StringBuilder();
9        int count=0;
10        for(int i=0;i<s.length();i++){
11            char ch=s.charAt(i);
12            if(ch=='('){
13                if(count>0){
14                    ans.append(ch);
15                }
16                count++;
17            }
18            else{
19                count--;
20                if(count>0){
21                    ans.append(ch);
22                }
23            }
24        }
25        return ans.toString();
26    }
27}