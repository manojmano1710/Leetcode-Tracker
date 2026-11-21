// Last updated: 21/11/2026, 19:00:56
1class Solution {
2public:
3    unordered_map<int, vector<int>> adj;
4    vector<int> v;
5    vector<int> ans;
6
7    void solve(string& s, vector<int>& parent, int curr) {
8        int c = s[curr] - 'a';
9        int last = v[c];
10        v[c] = curr;
11        for (auto it : adj[curr]) {
12            solve(s, parent, it);
13        }
14        v[c] = last;
15
16        if (curr != 0) {
17            int t = parent[curr];
18            if(last != -1){
19                t = last;
20            }
21            parent[curr] = t;
22            ans[t] += ans[curr];
23        }
24    }
25    vector<int> findSubtreeSizes(vector<int>& parent, string s) {
26        int n = parent.size();
27        for (int i = 1; i < n; i++) {
28            adj[parent[i]].push_back(i);
29        }
30        ans.assign(n, 1);
31        v.assign(26,-1);
32        solve(s,parent,0);
33        return ans;
34    }
35};