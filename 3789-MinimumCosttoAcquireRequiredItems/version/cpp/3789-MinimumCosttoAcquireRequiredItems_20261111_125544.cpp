// Last updated: 11/11/2026, 12:55:44
1class Solution {
2public:
3    long long minimumCost(int cost1, int cost2, int costBoth,
4                          int need1, int need2) {
5
6        // Case 1: Buy both items separately
7        long long c1 = 1LL * need1 * cost1
8                     + 1LL * need2 * cost2;
9
10        // Case 2: Buy only combined items
11        long long c2 = 1LL * max(need1, need2) * costBoth;
12
13        // Case 3: Buy combined items for overlapping needs,
14        // then purchase the remaining requirement separately
15        long long mult = need1 > need2 ? cost1 : cost2;
16
17        long long c3 = 1LL * min(need1, need2) * costBoth
18                     + 1LL * abs(need1 - need2) * mult;
19
20        return min({c1, c2, c3});
21    }
22};