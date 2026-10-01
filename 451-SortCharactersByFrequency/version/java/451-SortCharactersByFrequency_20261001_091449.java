// Last updated: 01/10/2026, 09:14:49
1class Solution {
2    public String frequencySort(String s) {
3        StringBuilder sb = new StringBuilder();
4        int[] freq = new int[128];
5        int n = s.length();
6
7        for (int i = 0; i < n; i++) {
8            freq[s.charAt(i)]++;
9        }
10
11        while (sb.length() < n) {
12            int max = 0;
13
14            for (int i = 1; i < 128; i++) {
15                if (freq[i] > freq[max]) {
16                    max = i;
17                }
18            }
19
20            for (int i = 0; i < freq[max]; i++) {
21                sb.append((char) max);
22            }
23
24            freq[max] = 0;
25        }
26
27        return sb.toString();
28    }
29}