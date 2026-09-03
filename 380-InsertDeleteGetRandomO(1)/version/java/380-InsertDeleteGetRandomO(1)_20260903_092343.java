// Last updated: 03/09/2026, 09:23:43
1class Solution {
2    ArrayList<Integer> nodes = new ArrayList<Integer>();
3    public Solution(ListNode head) {
4        while (head != null) {
5            nodes.add(head.val);
6            head = head.next;
7        }
8    }
9    
10    public int getRandom() {
11        int idx = (int)(Math.random() * this.nodes.size());
12        return this.nodes.get(idx);
13    }
14}