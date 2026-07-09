// Last updated: 09/07/2026, 15:08:37
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(
                maxDepth(root.left),
                maxDepth(root.right)
        );
    }
}