// Last updated: 02/09/2026, 09:25:14
1class Solution {
2public:
3    bool isValidSudoku(vector<vector<char>>& board) {
4
5        // 9 rows, 9 columns, 9 boxes
6        bool row[9][9] = {};
7        bool col[9][9] = {};
8        bool box[9][9] = {};
9
10        for (int i = 0; i < 9; i++) {
11            for (int j = 0; j < 9; j++) {
12
13                if (board[i][j] == '.')
14                    continue;
15
16                int num = board[i][j] - '1';
17
18                // Find which 3x3 box this cell belongs to
19                int boxIndex = (i / 3) * 3 + (j / 3);
20
21                // If already present in row, column, or box
22                if (row[i][num] ||
23                    col[j][num] ||
24                    box[boxIndex][num]) {
25                    return false;
26                }
27
28                // Mark it as present
29                row[i][num] = true;
30                col[j][num] = true;
31                box[boxIndex][num] = true;
32            }
33        }
34
35        return true;
36    }
37};