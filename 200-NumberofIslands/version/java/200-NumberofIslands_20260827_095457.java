// Last updated: 27/08/2026, 09:54:57
1class Trie {
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
12    public Trie() {
13        root = new TrieNode();
14    }
15
16    public void insert(String word) {
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
35
36        TrieNode current = root;
37
38        for (char ch : word.toCharArray()) {
39
40            int index = ch - 'a';
41
42            if (current.children[index] == null) {
43                return false;
44            }
45
46            current = current.children[index];
47        }
48
49        return current.isEnd;
50    }
51
52    public boolean startsWith(String prefix) {
53
54        TrieNode current = root;
55
56        for (char ch : prefix.toCharArray()) {
57
58            int index = ch - 'a';
59
60            if (current.children[index] == null) {
61                return false;
62            }
63
64            current = current.children[index];
65        }
66
67        return true;
68    }
69}