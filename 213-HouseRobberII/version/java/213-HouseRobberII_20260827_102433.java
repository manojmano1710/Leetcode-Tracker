// Last updated: 27/08/2026, 10:24:33
1import java.util.*;
2
3class Solution {
4    public int kthSmallest(TreeNode root, int k) {
5        Stack<TreeNode> stack = new Stack<>();
6        TreeNode current = root;
7
8        while (current != null || !stack.isEmpty()) {
9
10            // Go as far left as possible
11            while (current != null) {
12                stack.push(current);
13                current = current.left;
14            }
15
16            // Visit node
17            current = stack.pop();
18            k--;
19
20            // kth smallest found
21            if (k == 0) {
22                return current.val;
23            }
24
25            // Move to right subtree
26            current = current.right;
27        }
28
29        return -1;
30    }
31}