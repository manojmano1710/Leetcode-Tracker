// Last updated: 25/09/2026, 20:13:05
1class Solution {
2    int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};
3
4    void bfs(int X, int Y, boolean vis[][], int heights[][]) {
5        Queue<int[]> q = new LinkedList<>();
6        q.add(new int[]{X, Y});
7        vis[X][Y] = true;
8
9        int n = heights.length, m = heights[0].length;
10        while (!q.isEmpty()) {
11            int[] top = q.remove();
12            int x = top[0], y = top[1];
13
14            for (int[] d : dirs) {
15                int nx = x + d[0], ny = y + d[1];
16                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
17                    !vis[nx][ny] && heights[nx][ny] >= heights[x][y]) {
18                    vis[nx][ny] = true;
19                    q.add(new int[]{nx, ny});
20                }
21            }
22        }
23    }
24
25    public List<List<Integer>> pacificAtlantic(int[][] heights) {
26        List<List<Integer>> list = new ArrayList<>();
27        int n = heights.length, m = heights[0].length;
28        boolean po[][] = new boolean[n][m];
29        boolean ao[][] = new boolean[n][m];
30
31        for (int i = 0; i < n; i++) {
32            bfs(i, 0, po, heights);
33            bfs(i, m - 1, ao, heights);
34        }
35        for (int j = 0; j < m; j++) {
36            bfs(0, j, po, heights);
37            bfs(n - 1, j, ao, heights);
38        }
39
40        for (int i = 0; i < n; i++) {
41            for (int j = 0; j < m; j++) {
42                if (po[i][j] && ao[i][j]) list.add(Arrays.asList(i, j));
43            }
44        }
45        return list;
46    }
47}