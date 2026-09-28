// Last updated: 28/09/2026, 22:41:45
1class Solution {
2    private int helper(int[] map, char key, String spell){
3        int val = map[key - 'a'];
4        for(char c: spell.toCharArray()) map[c - 'a'] -= val;
5        return val;
6    }
7    public String originalDigits(String s) {
8        int map[] = new int[26], cnt[] = new int[10];
9        for(char c: s.toCharArray()) map[c - 'a']++;
10        
11        cnt[0] = helper(map, 'z', "zero");
12        cnt[2] = helper(map, 'w', "two");
13        cnt[4] = helper(map, 'u', "four");
14        cnt[6] = helper(map, 'x', "six");
15        cnt[8] = helper(map, 'g', "eight");
16
17        cnt[1] = helper(map, 'o', "one");
18        cnt[3] = helper(map, 't', "three");
19        cnt[5] = helper(map, 'f', "five");
20        cnt[7] = helper(map, 's', "seven");
21
22        cnt[9] = helper(map, 'i', "nine");
23
24        StringBuilder sb = new StringBuilder();
25        for(int i=0; i<=9; i++)
26            sb.append(("" + i).repeat(cnt[i]));
27        return sb.toString();
28    }
29}