// Last updated: 09/07/2026, 15:09:05
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode smaller = smallerDummy;
        ListNode greater = greaterDummy;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        smaller.next = greaterDummy.next;

        return smallerDummy.next;
    }
}