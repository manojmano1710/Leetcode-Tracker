// Last updated: 02/10/2026, 22:42:35
1class Solution {
2    public int hammingDistance(int x, int y) {
3        int xor=x^y;
4        int count=0;
5        while(xor>0){
6            xor=xor&(xor-1);
7            count++;
8        }
9        return count;
10    }
11}