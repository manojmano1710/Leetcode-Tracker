// Last updated: 21/09/2026, 18:18:09
1class Node {
2    int cnt;
3    Set<String> keys;
4    Node prev, next; 
5    public Node(int c) {
6        cnt = c;
7        keys = new HashSet<>();
8        prev = next = null;
9    }
10}
11class AllOne {
12    private Map<String, Integer> keyCnt; 
13    private Map<Integer, Node> cntNodeMap; 
14    private Node head, tail;
15    public AllOne() {
16        keyCnt = new HashMap<>();
17        cntNodeMap = new HashMap<>();
18        head = new Node(Integer.MIN_VALUE);
19        tail = new Node(Integer.MAX_VALUE);
20        head.next = tail;
21        tail.prev = head;
22    }
23    private Node addNodeAfter(Node node, int c) {
24        Node newNode = new Node(c);
25        newNode.next = node.next;
26        newNode.prev = node;
27        node.next.prev = newNode;
28        node.next = newNode;
29        cntNodeMap.put(c, newNode);
30        return newNode;
31    }
32    private void removeNode(Node node) {
33        node.prev.next = node.next;
34        node.next.prev = node.prev;
35        cntNodeMap.remove(node.cnt);
36    }
37    public void inc(String key) {
38        int c = keyCnt.getOrDefault(key, 0);
39        keyCnt.put(key, c + 1);
40        Node curr = cntNodeMap.get(c);
41        Node next = cntNodeMap.get(c + 1);
42        if (next == null) next = addNodeAfter(curr == null ? head : curr, c + 1);
43        next.keys.add(key);
44        if (curr != null) {
45            curr.keys.remove(key);
46            if (curr.keys.isEmpty()) removeNode(curr);
47        }
48    }
49    public void dec(String key) {
50        int c = keyCnt.get(key);
51        if (c == 1) keyCnt.remove(key);
52        else keyCnt.put(key, c - 1);
53
54        Node curr = cntNodeMap.get(c);
55        Node prev = cntNodeMap.get(c - 1);
56
57        if (c > 1 && prev == null) prev = addNodeAfter(curr.prev, c - 1);
58        if (c > 1) prev.keys.add(key);
59
60        curr.keys.remove(key);
61        if (curr.keys.isEmpty()) removeNode(curr);
62    }
63    public String getMaxKey() {
64        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
65    }
66    public String getMinKey() {
67        return head.next == tail ? "" : head.next.keys.iterator().next();
68    }
69}