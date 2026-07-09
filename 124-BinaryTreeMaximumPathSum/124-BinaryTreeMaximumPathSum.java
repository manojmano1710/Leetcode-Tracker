// Last updated: 09/07/2026, 15:08:06
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));   // ignore negatives
        int right = Math.max(0, dfs(node.right));

        // path through current node
        int current = node.val + left + right;

        maxSum = Math.max(maxSum, current);

        // return best path going upward
        return node.val + Math.max(left, right);
    }
}