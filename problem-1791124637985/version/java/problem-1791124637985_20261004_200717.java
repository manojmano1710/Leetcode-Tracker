// Last updated: 04/10/2026, 20:07:17
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
16class Solution 
17{
18    List<Integer> list = new ArrayList<>();
19    TreeNode prev = null;
20    int max = 0;
21    int count = 0;
22
23    public int[] findMode(TreeNode root) 
24    {
25        dfs(root);
26        int n = list.size();
27        int[] ans = new int[n];
28
29        for(int i = 0; i < n; i++)
30        {
31            ans[i] = list.get(i);
32        }
33
34        return ans;
35    }
36
37    void dfs(TreeNode cur)
38    {
39        if(cur == null)
40        {
41            return;
42        }
43
44        dfs(cur.left);
45
46        if(prev != null && prev.val == cur.val)
47        {
48            count++;
49        }
50        else
51        {
52            count = 1;
53        }
54
55        if(count > max)
56        {
57            list.clear();
58            max = count;
59            list.add(cur.val);
60        }
61        else if(count == max)
62        {
63            list.add(cur.val);
64        }
65
66        prev = cur;
67
68        dfs(cur.right);
69    }
70}