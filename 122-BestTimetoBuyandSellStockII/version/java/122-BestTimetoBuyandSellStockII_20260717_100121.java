// Last updated: 17/07/2026, 10:01:21
1class Solution {
2    public boolean isPalindrome(String s) {
3        int left = 0;
4        int right = s.length() - 1;
5
6        while (left < right) {
7
8            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
9                left++;
10            }
11
12            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
13                right--;
14            }
15
16            if (Character.toLowerCase(s.charAt(left)) !=
17                Character.toLowerCase(s.charAt(right))) {
18                return false;
19            }
20
21            left++;
22            right--;
23        }
24
25        return true;
26    }
27}