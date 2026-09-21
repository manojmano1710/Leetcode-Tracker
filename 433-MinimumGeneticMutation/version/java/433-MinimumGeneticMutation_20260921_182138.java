// Last updated: 21/09/2026, 18:21:38
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
17    // Map for keeping track of (PrefixSum, timesPrefixSumSeen) during traversal
18    Map<Long, Integer> hmap;
19    int count;
20
21    public int pathSum(TreeNode root, int targetSum) {
22        hmap = new HashMap<>();
23        count = 0;
24
25        dfs(root, 0, targetSum);
26
27        return count;
28    }
29
30    private void dfs(TreeNode root, long prefixSum, int targetSum) {
31        // base case
32        if (root == null) return;
33
34        
35        prefixSum += root.val;
36        
37        // If map contains a sum equal to (prefixSum - targetSum), we need to increment count that many times
38        if (hmap.containsKey(prefixSum-targetSum)) {
39            count += hmap.get(prefixSum-targetSum);
40        } 
41        
42        // There can be cases when the prefixSum is directly equal to targetSum, we need to increment count
43        if (targetSum == prefixSum) {
44            count++;
45        }
46
47        // Update the prefixSum till current node and it's count
48        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);
49
50        // Recurse
51        dfs(root.left, prefixSum, targetSum);
52        dfs(root.right, prefixSum, targetSum);
53
54        // Backtrack
55        hmap.put(prefixSum, hmap.get(prefixSum) - 1);
56        
57    }
58}