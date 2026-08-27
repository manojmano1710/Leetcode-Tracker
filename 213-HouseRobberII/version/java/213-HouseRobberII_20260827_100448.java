// Last updated: 27/08/2026, 10:04:48
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> combinationSum3(int k, int n) {
5        List<List<Integer>> result = new ArrayList<>();
6
7        backtrack(1, k, n, new ArrayList<>(), result);
8
9        return result;
10    }
11
12    private void backtrack(int start, int k, int target,
13                           List<Integer> current,
14                           List<List<Integer>> result) {
15
16        if (k == 0) {
17            if (target == 0) {
18                result.add(new ArrayList<>(current));
19            }
20            return;
21        }
22
23        for (int i = start; i <= 9; i++) {
24
25            if (i > target) {
26                break;
27            }
28
29            current.add(i);
30
31            // i + 1 means the same number cannot be used again
32            backtrack(i + 1, k - 1, target - i, current, result);
33
34            current.remove(current.size() - 1);
35        }
36    }
37}