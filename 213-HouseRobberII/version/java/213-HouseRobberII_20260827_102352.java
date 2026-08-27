// Last updated: 27/08/2026, 10:23:52
1import java.util.*;
2
3class Solution {
4    public List<Integer> majorityElement(int[] nums) {
5
6        int candidate1 = 0;
7        int candidate2 = 0;
8        int count1 = 0;
9        int count2 = 0;
10
11        // Find two possible candidates
12        for (int num : nums) {
13
14            if (num == candidate1) {
15                count1++;
16            } 
17            else if (num == candidate2) {
18                count2++;
19            } 
20            else if (count1 == 0) {
21                candidate1 = num;
22                count1 = 1;
23            } 
24            else if (count2 == 0) {
25                candidate2 = num;
26                count2 = 1;
27            } 
28            else {
29                count1--;
30                count2--;
31            }
32        }
33
34        // Verify the candidates
35        count1 = 0;
36        count2 = 0;
37
38        for (int num : nums) {
39            if (num == candidate1) {
40                count1++;
41            }
42            if (num == candidate2) {
43                count2++;
44            }
45        }
46
47        List<Integer> result = new ArrayList<>();
48
49        if (count1 > nums.length / 3) {
50            result.add(candidate1);
51        }
52
53        if (candidate2 != candidate1 && count2 > nums.length / 3) {
54            result.add(candidate2);
55        }
56
57        return result;
58    }
59}