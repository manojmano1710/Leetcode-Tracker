// Last updated: 25/09/2026, 20:10:34
1class Solution {
2
3    public List<String> fizzBuzz(int n) {
4
5        List<String> str = new ArrayList<>();
6
7        for (int i = 1; i <= n; i++) {
8
9            if (i % 3 == 0 && i % 5 == 0) {
10                str.add("FizzBuzz");
11
12            } else if (i % 3 == 0) {
13                str.add("Fizz");
14
15            } else if (i % 5 == 0) {
16                str.add("Buzz");
17
18            } else {
19                str.add(String.valueOf(i));
20            }
21        }
22
23        return str;
24    }
25}