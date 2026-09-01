// Last updated: 01/09/2026, 10:03:01
1class Solution {
2public:
3    vector<int> rightSideView(TreeNode* root) {
4
5        vector<int> ans;
6
7        if (root == nullptr)
8            return ans;
9
10        queue<TreeNode*> q;
11        q.push(root);
12
13        while (!q.empty()) {
14
15            int size = q.size();
16
17            for (int i = 0; i < size; i++) {
18
19                TreeNode* node = q.front();
20                q.pop();
21
22                // Last node of this level
23                if (i == size - 1)
24                    ans.push_back(node->val);
25
26                if (node->left)
27                    q.push(node->left);
28
29                if (node->right)
30                    q.push(node->right);
31            }
32        }
33
34        return ans;
35    }
36};