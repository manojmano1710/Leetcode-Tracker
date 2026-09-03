// Last updated: 03/09/2026, 09:30:23
1class Solution {
2     public int firstUniqChar(String s) {
3        // Stores lowest index / first index
4        int ans = Integer.MAX_VALUE;
5        // Iterate from a to z which is 26 which makes it constant
6        for(char c='a'; c<='z';c++){
7            // indexOf will return first index of alphabet and lastIndexOf will return last index
8            // if both are equal then it has occured only once.
9            // through this we will get all index's which are occured once
10            // but our answer is lowest index
11            int index = s.indexOf(c);
12            if(index!=-1&&index==s.lastIndexOf(c)){
13                ans = Math.min(ans,index);
14            }
15        }
16
17        // If ans remain's Integer.MAX_VALUE then their is no unique character
18        return ans==Integer.MAX_VALUE?-1:ans;
19    }   
20}