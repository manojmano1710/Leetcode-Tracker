// Last updated: 27/08/2026, 10:20:21
1class Solution {
2    public int computeArea(
3            int ax1, int ay1, int ax2, int ay2,
4            int bx1, int by1, int bx2, int by2) {
5
6        int area1 = (ax2 - ax1) * (ay2 - ay1);
7        int area2 = (bx2 - bx1) * (by2 - by1);
8
9        int overlapWidth =
10            Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
11
12        int overlapHeight =
13            Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
14
15        int overlap = overlapWidth * overlapHeight;
16
17        return area1 + area2 - overlap;
18    }
19}