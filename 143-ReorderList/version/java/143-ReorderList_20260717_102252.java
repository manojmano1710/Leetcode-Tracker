// Last updated: 17/07/2026, 10:22:52
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) {
9 *         this.val = val;
10 *         this.next = next;
11 *     }
12 * }
13 */
14
15class Solution {
16    public void reorderList(ListNode head) {
17
18        if (head == null || head.next == null) {
19            return;
20        }
21
22        // Step 1: Find the middle
23        ListNode slow = head;
24        ListNode fast = head;
25
26        while (fast.next != null && fast.next.next != null) {
27            slow = slow.next;
28            fast = fast.next.next;
29        }
30
31        // Step 2: Reverse second half
32        ListNode prev = null;
33        ListNode curr = slow.next;
34        slow.next = null;
35
36        while (curr != null) {
37            ListNode next = curr.next;
38            curr.next = prev;
39            prev = curr;
40            curr = next;
41        }
42
43        // Step 3: Merge two halves
44        ListNode first = head;
45        ListNode second = prev;
46
47        while (second != null) {
48            ListNode temp1 = first.next;
49            ListNode temp2 = second.next;
50
51            first.next = second;
52            second.next = temp1;
53
54            first = temp1;
55            second = temp2;
56        }
57    }
58}