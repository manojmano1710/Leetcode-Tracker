// Last updated: 17/07/2026, 10:19:27
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
14    public boolean hasCycle(ListNode head) {
15
16        if (head == null) {
17            return false;
18        }
19
20        ListNode slow = head;
21        ListNode fast = head;
22
23        while (fast != null && fast.next != null) {
24
25            slow = slow.next;
26            fast = fast.next.next;
27
28            if (slow == fast) {
29                return true;
30            }
31        }
32
33        return false;
34    }
35}