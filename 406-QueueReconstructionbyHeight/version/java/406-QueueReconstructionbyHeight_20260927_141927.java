// Last updated: 27/09/2026, 14:19:27
1import java.util.PriorityQueue;
2
3class Solution {
4    public int trapRainWater(int[][] heightMap) {
5        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
6            return 0;
7
8        int m = heightMap.length, n = heightMap[0].length;
9        boolean[][] visited = new boolean[m][n];
10        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
11
12        // Add boundary cells
13        for (int i = 0; i < m; ++i) {
14            for (int j : new int[]{0, n - 1}) {
15                minHeap.offer(new int[]{heightMap[i][j], i, j});
16                visited[i][j] = true;
17            }
18        }
19        for (int j = 0; j < n; ++j) {
20            for (int i : new int[]{0, m - 1}) {
21                if (!visited[i][j]) {
22                    minHeap.offer(new int[]{heightMap[i][j], i, j});
23                    visited[i][j] = true;
24                }
25            }
26        }
27
28        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
29        int waterTrapped = 0;
30
31        while (!minHeap.isEmpty()) {
32            int[] cell = minHeap.poll();
33            int height = cell[0], x = cell[1], y = cell[2];
34
35            for (int[] dir : directions) {
36                int nx = x + dir[0], ny = y + dir[1];
37                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
38                    waterTrapped += Math.max(0, height - heightMap[nx][ny]);
39                    minHeap.offer(new int[]{Math.max(height, heightMap[nx][ny]), nx, ny});
40                    visited[nx][ny] = true;
41                }
42            }
43        }
44
45        return waterTrapped;
46    }
47}