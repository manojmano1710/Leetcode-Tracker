// Last updated: 27/08/2026, 10:16:52
1import java.util.*;
2
3class Solution {
4    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
5
6        TreeSet<Long> set = new TreeSet<>();
7
8        for (int i = 0; i < nums.length; i++) {
9
10            long current = nums[i];
11
12            Long candidate = set.ceiling(current - (long) valueDiff);
13
14            if (candidate != null &&
15                candidate <= current + (long) valueDiff) {
16                return true;
17            }
18
19            set.add(current);
20
21            // Keep only the previous indexDiff elements
22            if (i >= indexDiff) {
23                set.remove((long) nums[i - indexDiff]);
24            }
25        }
26
27        return false;
28    }
29}