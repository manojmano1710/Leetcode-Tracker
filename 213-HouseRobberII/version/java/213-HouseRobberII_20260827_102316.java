// Last updated: 27/08/2026, 10:23:16
1import java.util.*;
2
3class Solution {
4    public List<String> summaryRanges(int[] nums) {
5        List<String> result = new ArrayList<>();
6
7        if (nums.length == 0) {
8            return result;
9        }
10
11        int start = nums[0];
12
13        for (int i = 1; i <= nums.length; i++) {
14
15            // End of a consecutive range
16            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
17
18                if (start == nums[i - 1]) {
19                    result.add(String.valueOf(start));
20                } else {
21                    result.add(start + "->" + nums[i - 1]);
22                }
23
24                // Start a new range
25                if (i < nums.length) {
26                    start = nums[i];
27                }
28            }
29        }
30
31        return result;
32    }
33}