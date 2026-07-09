// Last updated: 09/07/2026, 15:09:12
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Check for duplicates
            if (curr.next != null && curr.val == curr.next.val) {

                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                prev.next = curr.next; // Skip all duplicates
            } else {
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}