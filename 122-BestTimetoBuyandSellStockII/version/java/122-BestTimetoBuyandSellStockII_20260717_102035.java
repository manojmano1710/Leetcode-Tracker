// Last updated: 17/07/2026, 10:20:35
1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12
13public class Solution {
14
15    public ListNode detectCycle(ListNode head) {
16
17        if (head == null) {
18            return null;
19        }
20
21        ListNode slow = head;
22        ListNode fast = head;
23
24        // Phase 1: Detect cycle
25        while (fast != null && fast.next != null) {
26
27            slow = slow.next;
28            fast = fast.next.next;
29
30            if (slow == fast) {
31
32                // Phase 2: Find start of cycle
33                ListNode ptr = head;
34
35                while (ptr != slow) {
36                    ptr = ptr.next;
37                    slow = slow.next;
38                }
39
40                return ptr;
41            }
42        }
43
44        return null;
45    }
46}