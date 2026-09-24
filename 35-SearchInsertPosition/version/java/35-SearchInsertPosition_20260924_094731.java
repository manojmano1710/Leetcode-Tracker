// Last updated: 24/09/2026, 09:47:31
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
16class Solution {
17    
18    public int sumOfLeftLeaves(TreeNode root) {
19       return func(root,false);
20    }
21    public  int func(TreeNode root,boolean found){
22         if(root==null){
23            return 0;
24
25        }
26       
27        if(root.left==null && root.right==null && found){
28           return root.val;
29         
30        }
31       int l= func(root.left,true);
32       int r= func(root.right,false);
33        return l+r;
34       
35    }
36}