// Last updated: 27/08/2026, 10:15:52
1import java.util.*;
2
3class Solution {
4    public boolean containsNearbyDuplicate(int[] nums, int k) {
5
6        HashMap<Integer, Integer> map = new HashMap<>();
7
8        for (int i = 0; i < nums.length; i++) {
9
10            if (map.containsKey(nums[i])) {
11
12                int previousIndex = map.get(nums[i]);
13
14                if (i - previousIndex <= k) {
15                    return true;
16                }
17            }
18
19            map.put(nums[i], i);
20        }
21
22        return false;
23    }
24}