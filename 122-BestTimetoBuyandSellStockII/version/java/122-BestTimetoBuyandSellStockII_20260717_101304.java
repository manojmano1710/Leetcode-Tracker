// Last updated: 17/07/2026, 10:13:04
1import java.util.Arrays;
2
3class Solution {
4    public int candy(int[] ratings) {
5
6        int n = ratings.length;
7
8        int[] candies = new int[n];
9
10        Arrays.fill(candies, 1);
11
12        // Left to Right
13        for (int i = 1; i < n; i++) {
14            if (ratings[i] > ratings[i - 1]) {
15                candies[i] = candies[i - 1] + 1;
16            }
17        }
18
19        // Right to Left
20        for (int i = n - 2; i >= 0; i--) {
21            if (ratings[i] > ratings[i + 1]) {
22                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
23            }
24        }
25
26        int total = 0;
27
28        for (int candy : candies) {
29            total += candy;
30        }
31
32        return total;
33    }
34}