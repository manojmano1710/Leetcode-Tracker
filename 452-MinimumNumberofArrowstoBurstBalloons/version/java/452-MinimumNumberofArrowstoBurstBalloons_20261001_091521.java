// Last updated: 01/10/2026, 09:15:21
1class Solution {
2    public int findMinArrowShots(int[][] points) {
3        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0])); // Sort balloons by their starting point
4        int count=1; // Start with 1 arrow for the first balloon
5        // Possible arrow range where the first arrow can be shot
6        int start=points[0][0];
7        int end=points[0][1];
8        for(int i=1;i<points.length;i++){ // Start from the second balloon
9            if(end>=points[i][0]){ // If current balloon overlaps with the arrow range
10                // Keep only the common overlapping range
11                start=points[i][0];
12                end=Math.min(end,points[i][1]);
13            }else{ // No overlap, current arrow cannot burst this balloon
14                count++; // So we need another arrow
15                // Start a new possible arrow range
16                start=points[i][0];
17                end=points[i][1];
18            }
19        }
20        return count;
21    }
22}