// Last updated: 17/07/2026, 10:02:12
1import java.util.*;
2
3class Solution {
4    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
5
6        Set<String> set = new HashSet<>(wordList);
7
8        if (!set.contains(endWord)) {
9            return 0;
10        }
11
12        Queue<String> queue = new LinkedList<>();
13        queue.offer(beginWord);
14
15        int level = 1;
16
17        while (!queue.isEmpty()) {
18
19            int size = queue.size();
20
21            for (int i = 0; i < size; i++) {
22
23                String word = queue.poll();
24
25                if (word.equals(endWord)) {
26                    return level;
27                }
28
29                char[] arr = word.toCharArray();
30
31                for (int j = 0; j < arr.length; j++) {
32
33                    char original = arr[j];
34
35                    for (char c = 'a'; c <= 'z'; c++) {
36
37                        arr[j] = c;
38                        String nextWord = new String(arr);
39
40                        if (set.contains(nextWord)) {
41                            queue.offer(nextWord);
42                            set.remove(nextWord);
43                        }
44                    }
45
46                    arr[j] = original;
47                }
48            }
49
50            level++;
51        }
52
53        return 0;
54    }
55}