// Last updated: 29/09/2026, 09:28:09
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode rev(ListNode l){
13        ListNode curr = l;
14        ListNode prev = null;
15        ListNode next;
16
17        while(curr!=null){
18            next = curr.next;
19            curr.next = prev;
20            prev = curr;
21            curr = next;
22        }
23
24        return prev;
25    }
26    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
27        if(l1.val==0){
28            return l2;
29        }else if(l2.val==0){
30            return l1;
31        }
32
33        ListNode t1 = rev(l1);
34        ListNode t2 = rev(l2);
35
36        ListNode c1 = t1;
37        ListNode c2 = t2;
38        int carry = 0;
39        ListNode dummy = new ListNode(-1);
40        ListNode temp = dummy;
41
42        while(c1!=null&&c2!=null){
43                int k = c1.val + c2.val + carry;
44            
45                if(k>9){
46                    carry = 1;
47                    k = k%10;
48                }else{
49                    carry = 0;
50                }
51                ListNode a1 = new ListNode(k);
52                temp.next = a1;
53                temp = temp.next;
54                
55
56                c1 = c1.next;
57                c2 = c2.next;
58            
59        }
60        while(c1!=null){
61            int k = c1.val + carry;
62            if (k > 9) {
63                carry = 1;
64                k = k % 10;
65            } else {
66                carry = 0;
67            }
68            ListNode a1 = new ListNode(k);
69            temp.next = a1;
70            temp = temp.next;
71
72            c1 = c1.next;
73        }
74
75        while(c2!=null){
76            int k = c2.val + carry;
77            if (k > 9) {
78                carry = 1;
79                k = k % 10;
80            } else {
81                carry = 0;
82            }
83            ListNode a1 = new ListNode(k);
84            temp.next = a1;
85            temp = temp.next;
86
87            c2 = c2.next;
88        }
89        if (carry > 0) {
90            temp.next = new ListNode(carry);
91        }
92        ListNode finalans = rev(dummy.next);
93        return finalans;
94    }
95}