// Last updated: 27/11/2026, 19:07:46
1class Solution {
2    public int maximumSaleItems(int[][] items, int budget) {
3        int n = items.length;
4        int[] freq = new int[1501];
5        int minPrice = Integer.MAX_VALUE;
6
7        // Count factor frequencies and find the cheapest item
8        for (int[] item : items) {
9            freq[item[0]]++;
10            if (item[1] < minPrice) {
11                minPrice = item[1];
12            }
13        }
14
15        // Precompute how many items have a factor divisible by f
16        // Using the harmonic series trick reduces precomputation to O(M log M)
17        int[] divisibleCount = new int[1501];
18        for (int f = 1; f <= 1500; f++) {
19            if (freq[f] > 0) {
20                for (int multiple = f; multiple <= 1500; multiple += f) {
21                    divisibleCount[f] += freq[multiple];
22                }
23            }
24        }
25
26        // 0/1 Knapsack DP for the first purchase of each item
27        int[] dp = new int[budget + 1];
28        for (int[] item : items) {
29            int factor = item[0];
30            int price = item[1];
31            int gainedItems = divisibleCount[factor]; // 1 purchased + (divisibleCount - 1) free
32
33            for (int b = budget; b >= price; b--) {
34                int candidate = dp[b - price] + gainedItems;
35                if (candidate > dp[b]) {
36                    dp[b] = candidate;
37                }
38            }
39        }
40
41        // Spend any remaining budget greedily on the cheapest item
42        int maxItems = 0;
43        for (int b = 0; b <= budget; b++) {
44            int total = dp[b] + (budget - b) / minPrice;
45            if (total > maxItems) {
46                maxItems = total;
47            }
48        }
49
50        return maxItems;
51    }
52}