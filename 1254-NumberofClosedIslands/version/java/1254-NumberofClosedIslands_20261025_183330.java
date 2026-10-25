// Last updated: 25/10/2026, 18:33:30
1class Solution {
2    private int[][] grid;
3    private int m, n;
4
5    private boolean closed(int i, int j) {  // flood the island through (i, j); true if it never reaches the border
6        if (i < 0 || i >= m || j < 0 || j >= n) return false;  // stepped off the grid: the island touches the border
7        if (grid[i][j] == 1) return true;  // water, or land we already flooded
8        grid[i][j] = 1;  // visited: turn it into water
9        return closed(i + 1, j) & closed(i - 1, j) & closed(i, j + 1) & closed(i, j - 1);  // & (not &&) floods all 4 sides
10    }
11
12    public int closedIsland(int[][] grid) {
13        this.grid = grid;
14        m = grid.length;
15        n = grid[0].length;
16        int count = 0;
17        for (int i = 0; i < m; i++)
18            for (int j = 0; j < n; j++)
19                if (grid[i][j] == 0 && closed(i, j)) count++;
20        return count;
21    }
22}