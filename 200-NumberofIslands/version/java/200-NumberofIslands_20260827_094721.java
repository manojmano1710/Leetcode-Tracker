// Last updated: 27/08/2026, 09:47:21
1class Solution {
2
3    public int numIslands(char[][] grid) {
4
5        int count = 0;
6
7        for (int i = 0; i < grid.length; i++) {
8            for (int j = 0; j < grid[0].length; j++) {
9
10                if (grid[i][j] == '1') {
11                    count++;
12                    dfs(grid, i, j);
13                }
14            }
15        }
16
17        return count;
18    }
19
20    public void dfs(char[][] grid, int row, int col) {
21
22        // Boundary check
23        if (row < 0 || row >= grid.length ||
24            col < 0 || col >= grid[0].length ||
25            grid[row][col] == '0') {
26            return;
27        }
28
29        // Mark as visited
30        grid[row][col] = '0';
31
32        // Up
33        dfs(grid, row - 1, col);
34
35        // Down
36        dfs(grid, row + 1, col);
37
38        // Left
39        dfs(grid, row, col - 1);
40
41        // Right
42        dfs(grid, row, col + 1);
43    }
44}