// Last updated: 27/08/2026, 09:53:13
1class Solution {
2
3    public ListNode reverseList(ListNode head) {
4
5        ListNode prev = null;
6        ListNode curr = head;
7
8        while (curr != null) {
9
10            ListNode next = curr.next;
11
12            curr.next = prev;
13
14            prev = curr;
15
16            curr = next;
17        }
18
19        return prev;
20    }
21}