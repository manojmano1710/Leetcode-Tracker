// Last updated: 28/09/2026, 22:42:28
1class Solution {
2    public int characterReplacement(String s, int k) {
3        int l=0;
4        int r=0;
5        HashMap<Character,Integer> m=new HashMap<>();
6        int maxFreq=0;
7        int maxLen=0;
8        while(r<s.length())
9        {
10            char ch=s.charAt(r);
11            m.put(ch,m.getOrDefault(ch,0)+1);
12            maxFreq=Math.max(m.get(ch),maxFreq);
13            while((r-l+1)-maxFreq>k)
14            {
15                ch=s.charAt(l);
16                m.put(ch,m.getOrDefault(ch,0)-1);
17                l++;
18            }
19            maxLen=Math.max((r-l+1),maxLen);
20            r++;
21        }
22        return maxLen;
23    }
24}