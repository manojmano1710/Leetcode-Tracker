// Last updated: 27/10/2026, 19:44:09
1class Solution {
2    public String[] createGrid(int m, int n) {
3        String[] grid = new String[m];
4        char[] row = new char[n];
5        for (int j = 0; j < n; ++j) {
6            row[j] = '#';
7        }
8        for (int i = 0; i < m; ++i) {
9            grid[i] = new String(row);
10        }
11        char[] first = grid[0].toCharArray();
12        for (int j = 0; j < n; ++j) {
13            first[j] = '.';
14        }
15        grid[0] = new String(first);
16        for (int i = 0; i < m; ++i) {
17            char[] r = grid[i].toCharArray();
18            r[n - 1] = '.';
19            grid[i] = new String(r);
20        }
21        return grid;
22    }
23}