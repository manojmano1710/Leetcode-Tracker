// Last updated: 14/10/2026, 14:03:22
1class Solution {
2    public String maxSumOfSquares(int num, int sum) {
3        if (sum > 9L * num) return "";
4        int q = sum / 9;
5        int r = sum % 9;
6        StringBuilder sb = new StringBuilder(num);
7        for (int i = 0; i < q; i++) sb.append('9');
8        if (r > 0) sb.append((char)('0' + r));
9        for (int i = q + (r > 0 ? 1 : 0); i < num; i++) sb.append('0');
10        return sb.toString();
11    }
12}