// Last updated: 25/11/2026, 22:08:52
1class Solution {
2    boolean isValid(int[] nums, int k) {
3        int n = nums.length;
4        int l = 0, r = 0;
5
6        HashMap<Long, Integer> mp = new HashMap<>();
7
8        long mod = 1000000007;
9        long base = 100001;
10        long p = 1;
11        long hash = 0;
12
13        // Calculate base^(k-1)
14        for (int i = 0; i < k - 1; i++) {
15            p = (p * base) % mod;
16        }
17
18        // Sliding Window + Rolling Hash
19        while (r < n) {
20
21            // Add incoming element
22            hash = (hash * base + nums[r]) % mod;
23
24            if (r - l + 1 == k) {
25
26                // Store frequency of current hash
27                mp.put(hash, mp.getOrDefault(hash, 0) + 1);
28
29                // Remove outgoing element
30                hash = (hash - nums[l] * p % mod + mod) % mod;
31
32                l++;
33            }
34            r++;
35        }
36
37        // Check whether a unique subarray exists
38        for (int e : mp.values()) {
39            if (e == 1) return true;
40        }
41
42        return false;
43    }
44
45    public int smallestUniqueSubarray(int[] nums) {
46        int n = nums.length;
47        int l = 1;
48        int h = n;
49        int ans = n;
50
51        // Binary Search on Answer
52        while (l <= h) {
53            int m = l + (h - l) / 2;
54
55            if (isValid(nums, m)) {
56                h = m - 1;
57                ans = m;
58            } else {
59                l = m + 1;
60            }
61        }
62
63        return ans;
64    }
65}