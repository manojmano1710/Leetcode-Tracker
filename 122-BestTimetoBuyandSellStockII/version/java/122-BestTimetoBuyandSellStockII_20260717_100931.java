// Last updated: 17/07/2026, 10:09:31
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6
7    public Node() {
8        val = 0;
9        neighbors = new ArrayList<Node>();
10    }
11
12    public Node(int _val) {
13        val = _val;
14        neighbors = new ArrayList<Node>();
15    }
16
17    public Node(int _val, ArrayList<Node> _neighbors) {
18        val = _val;
19        neighbors = _neighbors;
20    }
21}
22*/
23
24class Solution {
25
26    private HashMap<Node, Node> map = new HashMap<>();
27
28    public Node cloneGraph(Node node) {
29
30        if (node == null) {
31            return null;
32        }
33
34        // If already cloned, return it
35        if (map.containsKey(node)) {
36            return map.get(node);
37        }
38
39        // Create clone
40        Node clone = new Node(node.val);
41
42        // Store in map
43        map.put(node, clone);
44
45        // Clone neighbors
46        for (Node neighbor : node.neighbors) {
47            clone.neighbors.add(cloneGraph(neighbor));
48        }
49
50        return clone;
51    }
52}