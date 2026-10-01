// Last updated: 01/10/2026, 08:57:01
1class Solution {
2
3    int count = 0;
4
5    public int reversePairs(int[] nums) {
6        int n = nums.length;
7
8        divide(nums, 0, n-1);
9
10        return count;
11    }
12
13    public void conquer(int[] nums, int low, int mid, int high) {
14
15        int[] merged = new int[high - low + 1];
16
17        int i = low;
18        int j = mid + 1;
19        int x = 0;
20
21        while(i <= mid) {
22
23            while(j <= high && nums[i] > 2L * nums[j]) {
24                j++;
25            }
26
27            count += j - (mid + 1);
28            i++;
29        }
30
31        i = low;
32        j = mid + 1;
33
34        while(i <= mid && j <= high) {
35
36            if(nums[i] <= nums[j]) {
37                merged[x++] = nums[i++];
38            } else {
39                merged[x++] = nums[j++];
40            }
41        }
42
43        while(i <= mid) {
44            merged[x++] = nums[i++];
45        }
46
47        while(j <= high) {
48            merged[x++] = nums[j++];
49        }
50
51        for(i = 0, j = low; i < merged.length; i++, j++) {
52            nums[j] = merged[i];
53        }
54    }
55
56    public void divide(int[] nums, int low, int high) {
57
58        if(low >= high) return;
59
60        int mid = low + (high - low) / 2;
61
62        divide(nums, low, mid);
63        divide(nums, mid + 1, high);
64
65        conquer(nums, low, mid, high);
66    }
67}