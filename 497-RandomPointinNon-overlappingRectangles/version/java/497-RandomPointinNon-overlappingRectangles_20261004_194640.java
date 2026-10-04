// Last updated: 04/10/2026, 19:46:40
1class Solution {
2    
3    Random random;
4    TreeMap<Integer,int[]> map;
5    int areaSum = 0;
6    
7    public Solution(int[][] rects) {
8        this.random = new Random();
9        this.map = new TreeMap<>();
10        
11        for(int i = 0; i < rects.length; i++){
12            int [] rectangeCoordinates = rects[i];
13            int length = rectangeCoordinates[2] - rectangeCoordinates[0] + 1 ; // +1 as we need to consider edges also.
14            int breadth = rectangeCoordinates[3] - rectangeCoordinates[1] + 1 ;
15            
16            areaSum += length * breadth;
17            
18            map.put(areaSum,rectangeCoordinates);
19            
20        }
21        
22    }
23    
24    public int[] pick() {
25        int key = map.ceilingKey(random.nextInt(areaSum) + 1); //Don't forget to +1 here, because we need [1,area] while nextInt generates [0,area-1]
26        
27        int [] rectangle = map.get(key);
28        
29        int length = rectangle[2] - rectangle[0] + 1 ; // +1 as we need to consider edges also.
30        int breadth = rectangle[3] - rectangle[1] + 1 ;
31        
32        int x = rectangle[0] + random.nextInt(length); //return random length from starting position of x
33        int y = rectangle[1] + random.nextInt(breadth); // return random breadth from starting position of y
34        
35        return new int[]{x,y};
36        
37    }
38}