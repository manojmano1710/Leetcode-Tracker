// Last updated: 27/08/2026, 09:58:02
1class WordDictionary {
2
3    class TrieNode {
4
5        TrieNode[] children = new TrieNode[26];
6
7        boolean isEnd = false;
8    }
9
10    private TrieNode root;
11
12    public WordDictionary() {
13        root = new TrieNode();
14    }
15
16    public void addWord(String word) {
17
18        TrieNode current = root;
19
20        for (char ch : word.toCharArray()) {
21
22            int index = ch - 'a';
23
24            if (current.children[index] == null) {
25                current.children[index] = new TrieNode();
26            }
27
28            current = current.children[index];
29        }
30
31        current.isEnd = true;
32    }
33
34    public boolean search(String word) {
35        return dfs(root, word, 0);
36    }
37
38    private boolean dfs(TrieNode node, String word, int index) {
39
40        // We reached the end of the word
41        if (index == word.length()) {
42            return node.isEnd;
43        }
44
45        char ch = word.charAt(index);
46
47        // Normal character
48        if (ch != '.') {
49
50            int childIndex = ch - 'a';
51
52            if (node.children[childIndex] == null) {
53                return false;
54            }
55
56            return dfs(node.children[childIndex], word, index + 1);
57        }
58
59        // '.' can represent any character
60        for (int i = 0; i < 26; i++) {
61
62            if (node.children[i] != null) {
63
64                if (dfs(node.children[i], word, index + 1)) {
65                    return true;
66                }
67            }
68        }
69
70        return false;
71    }
72}