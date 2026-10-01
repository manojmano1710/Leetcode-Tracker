// Last updated: 01/10/2026, 22:17:54
1public class Solution {
2    public int islandPerimeter(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        int cnt = 0;
6        for (int i = 0; i < n; i++) {
7            for (int j = 0; j < m; j++) {
8                if (grid[i][j] == 1) {
9                    if ((j > 0 && grid[i][j - 1] == 0) || j == 0)
10                        cnt++;
11
12                    if ((i > 0 && grid[i - 1][j] == 0) || i == 0)
13                        cnt++;
14
15                    if ((j < m - 1 && grid[i][j + 1] == 0) || j == m - 1)
16                        cnt++;
17
18                    if ((i < n - 1 && grid[i + 1][j] == 0) || i == n - 1)
19                        cnt++;
20                }
21            }
22        }
23        return cnt;
24    }
25}