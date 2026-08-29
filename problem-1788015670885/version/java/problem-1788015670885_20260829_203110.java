// Last updated: 29/08/2026, 20:31:10
1class Solution {
2    public int minBishopMoves(int[] source, int[] target) {
3        int sr = source[0];
4        int sc = source[1];
5        int tr = target[0];
6        int tc = target[1];
7        if((sr + sc) % 2 != (tr + tc) % 2) {
8            return -1;
9        }
10        if(sr-sc == tr-tc || sr + sc == tr +tc){
11            return 1;
12        }
13        return 2;
14    }
15}