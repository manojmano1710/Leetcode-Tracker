// Last updated: 28/11/2026, 13:49:35
1class Solution {
2    int minPrice;
3    public int maximumSaleItems(int[][] items, int budget) {
4        int n = items.length;
5        int maxFac = 0;
6        for (var item : items)
7            maxFac = Math.max(maxFac, item[0]);
8        int[] fre = new int[maxFac + 1];
9        for (var item: items)
10            fre[item[0]]++;
11        for (int i = 1; i<=maxFac; i++) {
12            if (fre[i] > 0) {
13                for (int j = i*2; j<=maxFac; j+=i) {
14                    fre[i] += fre[j];
15                }
16            }
17        }
18        
19        Arrays.sort(items, (a,b) -> Integer.compare(a[1],b[1]));
20        minPrice = items[0][1];
21
22        int ans = 0;
23        for (int i = 0; i<n; i++) {
24            int price = items[i][1];
25            // subtract copy of itself
26            int copy = fre[items[i][0]] - 1;
27            if (price - minPrice > minPrice)
28                break;
29
30            int take = Math.min(copy, budget/price);
31            ans += (take * 2);
32            budget -= (take * price);
33        }
34        ans += (budget/minPrice);
35        return ans;
36    }
37}