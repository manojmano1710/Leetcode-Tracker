// Last updated: 27/08/2026, 10:10:46
1import java.util.*;
2
3class Solution {
4    public boolean containsDuplicate(int[] nums) {
5
6        HashSet<Integer> set = new HashSet<>();
7
8        for (int num : nums) {
9
10            if (set.contains(num)) {
11                return true;
12            }
13
14            set.add(num);
15        }
16
17        return false;
18    }
19}