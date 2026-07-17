// Last updated: 17/07/2026, 10:16:08
1/*
2// Definition for a Node.
3class Node {
4    int val;
5    Node next;
6    Node random;
7
8    public Node(int val) {
9        this.val = val;
10        this.next = null;
11        this.random = null;
12    }
13}
14*/
15
16import java.util.HashMap;
17
18class Solution {
19    public Node copyRandomList(Node head) {
20
21        if (head == null) {
22            return null;
23        }
24
25        HashMap<Node, Node> map = new HashMap<>();
26
27        // First pass: Create all nodes
28        Node current = head;
29
30        while (current != null) {
31            map.put(current, new Node(current.val));
32            current = current.next;
33        }
34
35        // Second pass: Set next and random pointers
36        current = head;
37
38        while (current != null) {
39
40            Node copy = map.get(current);
41
42            copy.next = map.get(current.next);
43            copy.random = map.get(current.random);
44
45            current = current.next;
46        }
47
48        return map.get(head);
49    }
50}