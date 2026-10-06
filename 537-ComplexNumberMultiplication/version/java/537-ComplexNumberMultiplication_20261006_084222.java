// Last updated: 06/10/2026, 08:42:22
1class Solution {
2    public String complexNumberMultiply(String num1, String num2) {
3        String[] nums1 = num1.split("\\+");
4        String[] nums2 = num2.split("\\+");
5
6        StringBuilder output = new StringBuilder();
7
8        int a = Integer.parseInt(nums1[0]);
9        int b = Integer.parseInt(nums1[1].replace("i", ""));
10        int c = Integer.parseInt(nums2[0]);
11        int d = Integer.parseInt(nums2[1].replace("i", ""));
12
13        int e = a * c;
14        int f = b * d;
15        int g = (a * d) + (b * c);
16        int h = e - f;
17
18        output.append(h);
19        output.append("+");
20        output.append(g);
21        output.append("i");
22
23        return output.toString();
24    }
25}