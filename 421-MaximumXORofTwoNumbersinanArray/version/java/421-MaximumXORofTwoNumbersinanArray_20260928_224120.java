// Last updated: 28/09/2026, 22:41:20
1class Solution {
2    public int findMaximumXOR(int[] nums) {
3        Trie t = new Trie();
4		for(int i : nums) {
5			t.add(i);
6		}
7		
8		int ans = 0;
9		
10		for(int i : nums) {
11			ans =Math.max(ans, t.getMaxXor(i));
12		}
13
14        return ans;
15    }
16
17    static class Trie{
18		class Node{
19			Node one;
20			Node zero;
21		}
22		
23		private Node root = new Node();
24		
25		public void add(int val) {
26			Node curr=root;
27			for(int i=31;i>=0;i--) {
28				int mask = (1<<i);
29				int bit = val & mask;
30				if(bit!=0) {
31					if(curr.one!=null) {
32						curr=curr.one;
33					}
34					else {
35						Node nn = new Node();
36						curr.one=nn;
37						curr=nn;
38					}
39				}
40				else{
41					if(curr.zero!=null) {
42						curr=curr.zero;
43					}
44					else {
45						Node nn = new Node();
46						curr.zero=nn;
47						curr=nn;
48					}
49				}
50			}
51		}
52		
53		public int getMaxXor(int x) {
54			Node curr = root;
55			int ans=0;
56			for(int i=31;i>=0;i--) {
57				int mask = (1<<i);
58				int bit = x & mask;
59				if(bit==0) {
60					if(curr.one!=null) {
61						ans = ans|(1<<i);
62						curr = curr.one;
63					}
64					else {
65						curr=curr.zero;
66					}
67				}
68				else {
69					if(curr.zero!=null) {
70						ans = ans|(1<<i);
71						curr = curr.zero;
72					}
73					else {
74						curr = curr.one;
75					}	
76				}	
77			}
78			return ans;
79		}
80	}
81}