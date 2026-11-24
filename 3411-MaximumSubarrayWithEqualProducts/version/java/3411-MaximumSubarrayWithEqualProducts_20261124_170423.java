// Last updated: 24/11/2026, 17:04:23
1class Solution {
2    public int maxLength(int[] nums) {
3        int n = nums.length;
4        int ans = 0;
5
6        for (int i = 0; i < n; i++) {
7            int prod = nums[i];
8            int g = nums[i];
9            int l = nums[i];
10
11            for (int j = i + 1; j < n; j++) {
12                prod *= nums[j];
13                g = gcd(g, nums[j]);
14                l = lcm(l, nums[j]);
15
16                if (prod > 25200) break;
17
18                if (l * g == prod) {
19                    ans = Math.max(ans, j - i + 1);
20                }
21            }
22        }
23        return ans;
24    }
25
26    private int gcd(int a, int b) {
27        while (b != 0) {
28            int temp = b;
29            b = a % b;
30            a = temp;
31        }
32        return a;
33    }
34
35    private int lcm(int a, int b) {
36        return (a / gcd(a, b)) * b;
37    }
38}