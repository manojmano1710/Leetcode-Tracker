// Last updated: 28/09/2026, 22:44:06
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public Node prev;
6    public Node next;
7    public Node child;
8};
9*/
10
11class Solution {
12    public Node flatten(Node head) {
13        if(head==null) return head;
14        Node curr=head;
15        while(curr!=null){
16            if(curr.child!=null){
17                Node nextnode=curr.next;
18                Node childtail=curr.child;
19                while(childtail.next!=null){
20                    childtail=childtail.next;
21                }
22                if(nextnode!=null){
23                    childtail.next=nextnode;
24                    nextnode.prev=childtail;
25                }
26                curr.next=curr.child;
27                curr.child.prev=curr;
28                curr.child=null;
29            }
30            curr=curr.next;
31        }
32        return head;
33    }
34}