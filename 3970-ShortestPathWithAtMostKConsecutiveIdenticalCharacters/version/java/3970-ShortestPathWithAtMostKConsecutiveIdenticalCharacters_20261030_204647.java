// Last updated: 30/10/2026, 20:46:47
1class Solution {
2    int dik[][];
3    public int shortestPath(int n, int[][] edges, String labels, int k) {
4        dik=new int[n][k+1];
5        List<List<int[]>>lst=new ArrayList<>();
6        for(int i=0;i<n;i++)lst.add(new ArrayList<>());
7        for(int e[]:edges){
8             lst.get(e[0]).add(new int[]{e[1],e[2]});
9        }
10        for(int u[]:dik)Arrays.fill(u,Integer.MAX_VALUE);
11        PriorityQueue<int[]>que=new PriorityQueue<>((a,b)->a[2]-b[2]);
12        que.offer(new int[]{0,1,0});
13        dik[0][1]=0;
14        while(!que.isEmpty()){
15            int p[]=que.poll();
16            int nd=p[0];
17            int con=p[1];
18            int w=p[2];
19            for(int kk[]:lst.get(nd)){
20                if(labels.charAt(nd)==labels.charAt(kk[0]) && con==k)continue;
21                if(labels.charAt(nd)==labels.charAt(kk[0])){
22                    if(dik[kk[0]][con+1]>w+kk[1]){
23                        dik[kk[0]][con+1]=w+kk[1];
24                        que.offer(new int[]{kk[0],con+1,dik[kk[0]][con+1]});
25                    }
26                }else if(dik[kk[0]][1]>w+kk[1]){
27                        dik[kk[0]][1]=w+kk[1];
28                         que.offer(new int[]{kk[0],1,dik[kk[0]][1]});
29                    }
30            }
31        }
32        int min=Integer.MAX_VALUE;
33        for(int kk:dik[n-1])if(min>kk)min=kk;
34        return min==Integer.MAX_VALUE?-1:min;
35    }
36}