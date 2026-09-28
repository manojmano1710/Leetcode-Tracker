// Last updated: 28/09/2026, 22:43:28
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> children;
6
7    public Node() {}
8
9    public Node(int _val) {
10        val = _val;
11    }
12
13    public Node(int _val, List<Node> _children) {
14        val = _val;
15        children = _children;
16    }
17};
18*/
19
20class Solution {
21    public List<List<Integer>> levelOrder(Node root) {
22        List<List<Integer>> res = new ArrayList<>();
23        if (root == null) return res;
24        Queue<Node> q = new LinkedList<>();
25        q.offer(root);
26        while (!q.isEmpty()){
27            int size = q.size();
28            ArrayList<Integer> level = new ArrayList<>();
29            for (int i = 0; i < size; i++){
30                Node node = q.poll();
31                level.add(node.val);
32                if (node.children != null){
33                    for (Node child : node.children) {
34                        q.offer(child);
35                    }
36                }
37            }
38            res.add(level);
39            }
40            return res;
41        }
42    }