// Last updated: 17/07/2026, 10:03:38
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16
17class Solution {
18    public int sumNumbers(TreeNode root) {
19        return dfs(root, 0);
20    }
21
22    private int dfs(TreeNode node, int current) {
23        if (node == null) {
24            return 0;
25        }
26
27        current = current * 10 + node.val;
28
29        // Leaf node
30        if (node.left == null && node.right == null) {
31            return current;
32        }
33
34        return dfs(node.left, current) + dfs(node.right, current);
35    }
36}