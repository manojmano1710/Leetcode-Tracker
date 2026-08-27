// Last updated: 27/08/2026, 10:22:07
1class Solution {
2    public TreeNode invertTree(TreeNode root) {
3
4        if (root == null) {
5            return null;
6        }
7
8        TreeNode temp = root.left;
9        root.left = root.right;
10        root.right = temp;
11
12        invertTree(root.left);
13        invertTree(root.right);
14
15        return root;
16    }
17}