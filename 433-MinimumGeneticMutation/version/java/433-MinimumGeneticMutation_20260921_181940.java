// Last updated: 21/09/2026, 18:19:40
1class Solution {
2    public int eraseOverlapIntervals(int[][] intervals) {
3
4        if (intervals.length == 0) {
5            return 0;
6        }
7
8        // Sort intervals by their end time
9        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
10
11        int count = 1;
12        int previous_interval = 0;
13
14        for (int i = 1; i < intervals.length; i++) {
15
16            // Current interval starts after
17            // or exactly when the previous one ends
18            if (intervals[i][0] >= intervals[previous_interval][1]) {
19                previous_interval = i;
20                count++;
21            }
22        }
23
24        // Total intervals - intervals we can keep
25        return intervals.length - count;
26    }
27}