// Last updated: 27/08/2026, 10:18:31
1class Solution {
2
3    public int countNodes(TreeNode root) {
4
5        if (root == null) {
6            return 0;
7        }
8
9        int leftHeight = getLeftHeight(root);
10        int rightHeight = getRightHeight(root);
11
12        // Perfect binary tree
13        if (leftHeight == rightHeight) {
14            return (1 << leftHeight) - 1;
15        }
16
17        // Otherwise, recursively count both subtrees
18        return 1 + countNodes(root.left) + countNodes(root.right);
19    }
20
21    private int getLeftHeight(TreeNode node) {
22
23        int height = 0;
24
25        while (node != null) {
26            height++;
27            node = node.left;
28        }
29
30        return height;
31    }
32
33    private int getRightHeight(TreeNode node) {
34
35        int height = 0;
36
37        while (node != null) {
38            height++;
39            node = node.right;
40        }
41
42        return height;
43    }
44}