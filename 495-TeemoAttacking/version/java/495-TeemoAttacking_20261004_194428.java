// Last updated: 04/10/2026, 19:44:28
1class Solution {
2    public int findPoisonedDuration(int[] timeSeries, int duration) {
3        int total = 0;
4
5        for (int i = 1; i < timeSeries.length; i++) {
6            total += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
7        }
8
9        total += duration;
10
11        return total;
12    }
13}