// Last updated: 21/09/2026, 18:20:34
1class Solution {
2    public int[] findRightInterval(int[][] intervals) {
3        PriorityQueue<int[]> minheapStart = new PriorityQueue<>((a, b) -> a[0] - b[0]);
4        PriorityQueue<int[]> minheapEnd = new PriorityQueue<>((a, b) -> a[0] - b[0]);
5        
6		// Build the 2 minHeaps
7        for(int i=0; i < intervals.length; i++){
8            minheapStart.add(new int[]{intervals[i][0], i});
9            minheapEnd.add(new int[]{intervals[i][1], i});
10        }
11        
12		// Define the final result[]
13        int[] result = new int[intervals.length];
14        
15		// Initialize the result[] with -1
16        for(int i=0; i < intervals.length; i++)
17            result[i] = -1;
18        
19        while(!minheapEnd.isEmpty()){
20		    // Fetch the smallest end index
21            int[] currEnd = minheapEnd.poll();
22            int currEndVal = currEnd[0];
23            int currEndIdx = currEnd[1];
24            
25            // Find the first start idx which is greater than or equal to the current end
26            while(!minheapStart.isEmpty() && currEndVal > minheapStart.peek()[0])
27                minheapStart.poll();
28            
29            // Since there are no more elements left in minheapStart, that means rest all indices in result[] will be 
30            // mapped to -1
31            if(minheapStart.isEmpty())
32                return result;
33            
34            // When minheapStart is not empty, then the top most element of minheapStart must be >= currEndVal
35            // So we place the corresponding index of the top most element of minheapStart in the corresponding 
36            // currEndIdx of the result[]
37            result[currEndIdx] = minheapStart.peek()[1];
38        }
39        return result;
40    }
41}