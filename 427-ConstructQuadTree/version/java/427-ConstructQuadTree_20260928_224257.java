// Last updated: 28/09/2026, 22:42:57
1class Solution {
2     public Node construct(int[][] grid) {
3        return make(grid, 0, 0, grid.length);
4    }
5    private Node make(int grid[][], int r, int c, int length) {
6        if(length == 1)
7            return new Node(grid[r][c] == 1? true : false, true);
8        Node topLeft = make(grid, r, c, length/2);
9        Node topRight = make(grid, r, c + length/2, length/2);
10        Node bottomLeft = make(grid, r + length/2, c, length/2);
11        Node bottomRight = make(grid, r + length/2, c + length/2, length/2);
12        if(topLeft.val == topRight.val && bottomLeft.val == bottomRight.val && topLeft.val == bottomLeft.val && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf)
13            return new Node(topLeft.val, true);
14        else
15            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
16    }
17}
18//Please upvote :)