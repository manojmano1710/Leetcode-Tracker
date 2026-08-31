// Last updated: 31/08/2026, 16:21:29
1/**
2 * Definition for singly-linked list.
3 * struct ListNode {
4 *     int val;
5 *     ListNode *next;
6 *     ListNode() : val(0), next(nullptr) {}
7 *     ListNode(int x) : val(x), next(nullptr) {}
8 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
9 * };
10 */
11
12class Solution {
13public:
14    bool isPalindrome(ListNode* head) {
15
16        // 1. Find the middle of the linked list
17        ListNode* slow = head;
18        ListNode* fast = head;
19
20        while (fast != nullptr && fast->next != nullptr) {
21            slow = slow->next;
22            fast = fast->next->next;
23        }
24
25        // 2. Reverse the second half
26        ListNode* prev = nullptr;
27
28        while (slow != nullptr) {
29            ListNode* nextNode = slow->next;
30            slow->next = prev;
31            prev = slow;
32            slow = nextNode;
33        }
34
35        // prev is now the head of the reversed second half
36
37        // 3. Compare first half and reversed second half
38        ListNode* left = head;
39        ListNode* right = prev;
40
41        while (right != nullptr) {
42            if (left->val != right->val) {
43                return false;
44            }
45
46            left = left->next;
47            right = right->next;
48        }
49
50        return true;
51    }
52};