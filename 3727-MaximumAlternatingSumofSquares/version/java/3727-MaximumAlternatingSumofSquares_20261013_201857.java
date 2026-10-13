// Last updated: 13/10/2026, 20:18:57
1class Solution {
2    private final Random random = new Random();
3
4    public long maxAlternatingSum(int[] nums) {
5        int n = nums.length, h = n / 2;
6        long[] sq = new long[n];
7        long total = 0;
8        for (int i = 0; i < n; i++) {
9            sq[i] = (long) nums[i] * nums[i];
10            total += sq[i];
11        }
12        select(sq, h);  // quickselect: the smallest half in front, any order
13        long small = 0;
14        for (int i = 0; i < h; i++) small += sq[i];
15        return total - 2 * small;  // add everything, then flip the smallest half to minus
16    }
17
18    private void select(long[] a, int k) {  // put the k smallest values in a[0..k), like C++ nth_element
19        int lo = 0, hi = a.length - 1;
20        while (lo < hi) {
21            long pivot = a[lo + random.nextInt(hi - lo + 1)];
22            int lt = lo, i = lo, gt = hi;  // a[lo..lt) < pivot, a[lt..i) == pivot, a(gt..hi] > pivot
23            while (i <= gt) {
24                if (a[i] < pivot) swap(a, lt++, i++);
25                else if (a[i] > pivot) swap(a, i, gt--);
26                else i++;
27            }
28            if (k < lt) hi = lt - 1;  // the boundary is among the smaller values
29            else if (k > gt + 1) lo = gt + 1;  // the boundary is among the bigger values
30            else return;  // the boundary falls on the pivot copies: done
31        }
32    }
33
34    private void swap(long[] a, int i, int j) {
35        long t = a[i];
36        a[i] = a[j];
37        a[j] = t;
38    }
39}