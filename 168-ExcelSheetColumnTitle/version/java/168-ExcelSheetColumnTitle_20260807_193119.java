// Last updated: 07/08/2026, 19:31:19
1class Solution {
2    public String convertToTitle(int columnNumber) {
3        StringBuilder result = new StringBuilder();
4
5        while (columnNumber > 0) {
6            columnNumber--;  // Adjust for 1-based indexing
7            result.append((char) ('A' + (columnNumber % 26)));
8            columnNumber /= 26;
9        }
10
11        return result.reverse().toString();
12    }
13}