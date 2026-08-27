// Last updated: 27/08/2026, 09:50:23
1class Solution {
2
3    public ListNode removeElements(ListNode head, int val) {
4
5        ListNode dummy = new ListNode(0);
6        dummy.next = head;
7
8        ListNode current = dummy;
9
10        while (current.next != null) {
11
12            if (current.next.val == val) {
13                current.next = current.next.next;
14            } else {
15                current = current.next;
16            }
17        }
18
19        return dummy.next;
20    }
21}