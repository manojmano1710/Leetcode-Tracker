// Last updated: 03/11/2026, 18:36:22
1class Solution {
2    public int minMoves(int[] nums) {
3
4        int maxElement = 0;
5
6        for (int num : nums) {
7            maxElement = Math.max(maxElement, num);
8        }
9
10        int moves = 0;
11
12        for (int num : nums) {
13            moves += maxElement - num;
14        }
15
16        return moves;
17    }
18}