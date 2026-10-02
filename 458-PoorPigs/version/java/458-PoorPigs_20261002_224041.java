// Last updated: 02/10/2026, 22:40:41
1class Solution {
2    public int poorPigs(int buckets, int tdie, int ttest) {
3        int test = ttest/tdie;
4        int i=0;
5        while(Math.pow(test+1,i)< buckets){
6            i++;
7        }return i;
8    }
9}