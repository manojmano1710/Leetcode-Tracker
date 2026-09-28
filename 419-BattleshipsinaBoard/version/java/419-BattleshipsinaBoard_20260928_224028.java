// Last updated: 28/09/2026, 22:40:28
1class Solution {
2    public int countBattleships(char[][] board) {
3        int cnt=0;
4        for(int i=0;i<board.length;i++){
5            for(int j=0;j<board[0].length;j++){
6                if(board[i][j]=='X'){
7                    cnt++;
8                    helper(i,j, board);
9                }
10            }
11        }
12
13        return cnt;
14    }
15
16    public void helper(int i, int j, char board[][]){
17        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='.'){
18            return;
19        }
20
21        board[i][j]='.';
22
23        int dir[][] = {
24            {1,0},{-1,0},{0,1},{0,-1}
25        };
26
27        for(int k=0;k<4;k++){
28            helper(i+dir[k][0], j+dir[k][1], board);
29        }
30    }
31}