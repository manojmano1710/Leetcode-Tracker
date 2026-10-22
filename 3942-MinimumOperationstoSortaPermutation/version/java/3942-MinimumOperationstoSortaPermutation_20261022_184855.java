// Last updated: 22/10/2026, 18:48:55
1class Solution {
2    public int minOperations(int[] nums) {
3        int n = nums.length;
4
5        if (n == 0) {
6            return -1;
7        }
8
9        int res = Integer.MAX_VALUE;
10        int[] target = new int[n];
11
12        for (int i = 0; i < n; i++) {
13            target[i] = i;
14        }
15
16        int k = -1;
17
18        for (int i = 0; i < n; i++) {
19            if (nums[i] == 0) {
20                k = i;
21                break;
22            }
23        }
24
25        if (k == -1) {
26            return -1;
27        }
28
29        int[] rotated = new int[n];
30
31        for (int i = 0; i < n; i++) {
32            rotated[i] = nums[(k + i) % n];
33        }
34
35        if (Arrays.equals(rotated, target)) {
36            res = Math.min(res, Math.min(k, n - k + 2));
37        }
38
39        int[] revNums = new int[n];
40
41        for (int i = 0; i < n; i++) {
42            revNums[i] = nums[n - 1 - i];
43        }
44
45        int kRev = n - 1 - k;
46
47        for (int i = 0; i < n; i++) {
48            rotated[i] = revNums[(kRev + i) % n];
49        }
50
51        if (Arrays.equals(rotated, target)) {
52            res = Math.min(
53                res,
54                Math.min(kRev + 1, n - kRev + 1)
55            );
56        }
57
58        return res == Integer.MAX_VALUE ? -1 : res;
59    }
60}