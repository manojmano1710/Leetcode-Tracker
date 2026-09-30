// Last updated: 30/09/2026, 09:17:27
1class Solution {
2    public int numberOfBoomerangs(int[][] points) {
3        int n = points.length;
4        if(n<3)return 0;
5        int count =0;
6        for(int i=0;i<n;i++){
7            HashMap<Long,Integer> hm= new HashMap<>();
8            for(int j=0;j<n;j++){
9                if(j==i)continue;
10                int y = points[i][1]-points[j][1];
11                int x = points[i][0]-points[j][0];
12                long key = y*y + x*x;
13                hm.put(key,hm.getOrDefault(key,0)+1);
14            }
15            for(Map.Entry<Long,Integer> u : hm.entrySet()){
16                int k = u.getValue();
17                if(k>1) count+= k*(k-1);
18            }
19        }
20        return count;
21    }
22}