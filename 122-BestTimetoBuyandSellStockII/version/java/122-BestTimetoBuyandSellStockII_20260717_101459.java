// Last updated: 17/07/2026, 10:14:59
1class Solution {
2    public int singleNumber(int[] nums) {
3
4        int ones = 0;
5        int twos = 0;
6
7        for (int num : nums) {
8
9            ones = (ones ^ num) & ~twos;
10            twos = (twos ^ num) & ~ones;
11
12        }
13
14        return ones;
15    }
16}