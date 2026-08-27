// Last updated: 27/08/2026, 10:04:14
1import java.util.PriorityQueue;
2
3class Solution {
4    public int findKthLargest(int[] nums, int k) {
5
6        PriorityQueue<Integer> pq = new PriorityQueue<>();
7
8        for (int num : nums) {
9            pq.offer(num);
10
11            if (pq.size() > k) {
12                pq.poll();
13            }
14        }
15
16        return pq.peek();
17    }
18}