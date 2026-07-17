// Last updated: 17/07/2026, 10:24:11
1import java.util.*;
2
3class Solution {
4
5    public List<Integer> preorderTraversal(TreeNode root) {
6
7        List<Integer> result = new ArrayList<>();
8
9        if (root == null) {
10            return result;
11        }
12
13        Stack<TreeNode> stack = new Stack<>();
14        stack.push(root);
15
16        while (!stack.isEmpty()) {
17
18            TreeNode current = stack.pop();
19
20            result.add(current.val);
21
22            // Push right first
23            if (current.right != null) {
24                stack.push(current.right);
25            }
26
27            // Push left second
28            if (current.left != null) {
29                stack.push(current.left);
30            }
31        }
32
33        return result;
34    }
35}