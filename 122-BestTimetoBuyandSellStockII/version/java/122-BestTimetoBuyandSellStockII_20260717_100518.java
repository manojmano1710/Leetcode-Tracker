// Last updated: 17/07/2026, 10:05:18
1import java.util.*;
2
3class Solution {
4
5    public List<List<String>> partition(String s) {
6        List<List<String>> result = new ArrayList<>();
7        backtrack(s, 0, new ArrayList<>(), result);
8        return result;
9    }
10
11    private void backtrack(String s, int start,
12                           List<String> current,
13                           List<List<String>> result) {
14
15        // Reached the end of the string
16        if (start == s.length()) {
17            result.add(new ArrayList<>(current));
18            return;
19        }
20
21        // Try every possible substring
22        for (int end = start; end < s.length(); end++) {
23
24            if (isPalindrome(s, start, end)) {
25
26                current.add(s.substring(start, end + 1));
27
28                backtrack(s, end + 1, current, result);
29
30                // Backtrack
31                current.remove(current.size() - 1);
32            }
33        }
34    }
35
36    private boolean isPalindrome(String s, int left, int right) {
37
38        while (left < right) {
39
40            if (s.charAt(left) != s.charAt(right)) {
41                return false;
42            }
43
44            left++;
45            right--;
46        }
47
48        return true;
49    }
50}