// Last updated: 09/07/2026, 15:09:10
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // remove duplicate
            } else {
                current = current.next; // move forward
            }
        }

        return head;
    }
}