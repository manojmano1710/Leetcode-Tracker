// Last updated: 17/07/2026, 10:04:22
1class Solution {
2
3    public void solve(char[][] board) {
4        if (board == null || board.length == 0) {
5            return;
6        }
7
8        int rows = board.length;
9        int cols = board[0].length;
10
11        // First and last column
12        for (int i = 0; i < rows; i++) {
13            dfs(board, i, 0);
14            dfs(board, i, cols - 1);
15        }
16
17        // First and last row
18        for (int j = 0; j < cols; j++) {
19            dfs(board, 0, j);
20            dfs(board, rows - 1, j);
21        }
22
23        // Convert surrounded O -> X
24        // Restore marked # -> O
25        for (int i = 0; i < rows; i++) {
26            for (int j = 0; j < cols; j++) {
27
28                if (board[i][j] == 'O') {
29                    board[i][j] = 'X';
30                } else if (board[i][j] == '#') {
31                    board[i][j] = 'O';
32                }
33
34            }
35        }
36    }
37
38    private void dfs(char[][] board, int i, int j) {
39
40        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
41                || board[i][j] != 'O') {
42            return;
43        }
44
45        board[i][j] = '#';
46
47        dfs(board, i + 1, j);
48        dfs(board, i - 1, j);
49        dfs(board, i, j + 1);
50        dfs(board, i, j - 1);
51    }
52}