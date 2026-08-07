// Last updated: 07/08/2026, 19:34:12
1class Solution {
2    public List<Integer> rightSideView(TreeNode root) {
3        List<Integer> result = new ArrayList<>();
4
5        if (root == null) {
6            return result;
7        }
8
9        Queue<TreeNode> queue = new LinkedList<>();
10        queue.offer(root);
11
12        while (!queue.isEmpty()) {
13            int size = queue.size();
14
15            for (int i = 0; i < size; i++) {
16                TreeNode node = queue.poll();
17
18                // Last node of the current level
19                if (i == size - 1) {
20                    result.add(node.val);
21                }
22
23                if (node.left != null) {
24                    queue.offer(node.left);
25                }
26
27                if (node.right != null) {
28                    queue.offer(node.right);
29                }
30            }
31        }
32
33        return result;
34    }
35}