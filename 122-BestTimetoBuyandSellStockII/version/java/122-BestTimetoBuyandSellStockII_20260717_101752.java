// Last updated: 17/07/2026, 10:17:52
1import java.util.*;
2
3class Solution {
4
5    public List<String> wordBreak(String s, List<String> wordDict) {
6
7        Set<String> set = new HashSet<>(wordDict);
8        Map<String, List<String>> memo = new HashMap<>();
9
10        return dfs(s, set, memo);
11    }
12
13    private List<String> dfs(String s, Set<String> set,
14                             Map<String, List<String>> memo) {
15
16        if (memo.containsKey(s)) {
17            return memo.get(s);
18        }
19
20        List<String> result = new ArrayList<>();
21
22        if (s.length() == 0) {
23            result.add("");
24            return result;
25        }
26
27        for (String word : set) {
28
29            if (s.startsWith(word)) {
30
31                List<String> subList = dfs(s.substring(word.length()), set, memo);
32
33                for (String sub : subList) {
34
35                    if (sub.equals("")) {
36                        result.add(word);
37                    } else {
38                        result.add(word + " " + sub);
39                    }
40                }
41            }
42        }
43
44        memo.put(s, result);
45
46        return result;
47    }
48}