// Last updated: 27/09/2026, 14:17:20
1class Solution {
2    public String toHex(int num) {
3        char[] hexDigits = {'0','1','2','3','4','5','6','7',
4                            '8','9','a','b','c','d','e','f'};
5        long k = num;
6        if (num < 0) k = (1L << 32) + k;
7        if (k == 0) return "0";
8        StringBuilder ans = new StringBuilder();
9        while (k != 0) {
10            int rem = (int)(k % 16);
11            k /= 16;
12            ans.append(hexDigits[rem]);
13        }
14        return ans.reverse().toString();
15    }
16}