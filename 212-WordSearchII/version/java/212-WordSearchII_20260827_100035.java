// Last updated: 27/08/2026, 10:00:35
1import java.util.*;
2
3class Solution {
4
5    class TrieNode {
6        TrieNode[] children = new TrieNode[26];
7        String word;
8    }
9
10    List<String> result = new ArrayList<>();
11
12    public List<String> findWords(char[][] board, String[] words) {
13
14        TrieNode root = new TrieNode();
15
16        // Insert all words into Trie
17        for (String word : words) {
18            TrieNode current = root;
19
20            for (char c : word.toCharArray()) {
21                int index = c - 'a';
22
23                if (current.children[index] == null) {
24                    current.children[index] = new TrieNode();
25                }
26
27                current = current.children[index];
28            }
29
30            current.word = word;
31        }
32
33        // Search board
34        for (int i = 0; i < board.length; i++) {
35            for (int j = 0; j < board[0].length; j++) {
36                dfs(board, i, j, root);
37            }
38        }
39
40        return result;
41    }
42
43    private void dfs(char[][] board, int row, int col, TrieNode node) {
44
45        // Outside the board
46        if (row < 0 || row >= board.length ||
47            col < 0 || col >= board[0].length) {
48            return;
49        }
50
51        char c = board[row][col];
52
53        // Already visited
54        if (c == '#') {
55            return;
56        }
57
58        TrieNode next = node.children[c - 'a'];
59
60        // Character doesn't continue any word
61        if (next == null) {
62            return;
63        }
64
65        // Found a complete word
66        if (next.word != null) {
67            result.add(next.word);
68
69            // Prevent duplicate result
70            next.word = null;
71        }
72
73        // Mark current cell as visited
74        board[row][col] = '#';
75
76        // Down
77        dfs(board, row + 1, col, next);
78
79        // Up
80        dfs(board, row - 1, col, next);
81
82        // Right
83        dfs(board, row, col + 1, next);
84
85        // Left
86        dfs(board, row, col - 1, next);
87
88        // Restore cell
89        board[row][col] = c;
90    }
91}