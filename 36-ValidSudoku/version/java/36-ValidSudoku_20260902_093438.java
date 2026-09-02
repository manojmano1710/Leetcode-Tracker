// Last updated: 02/09/2026, 09:34:38
1public class Solution {
2    public boolean isValidSerialization(String preorder) {
3        // using a stack, scan left to right
4        // case 1: we see a number, just push it to the stack
5        // case 2: we see #, check if the top of stack is also #
6        // if so, pop #, pop the number in a while loop, until top of stack is not #
7        // if not, push it to stack
8        // in the end, check if stack size is 1, and stack top is #
9        if (preorder == null) {
10            return false;
11        }
12        Stack<String> st = new Stack<>();
13        String[] strs = preorder.split(",");
14        for (int pos = 0; pos < strs.length; pos++) {
15            String curr = strs[pos];
16            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
17                st.pop();
18                if (st.isEmpty()) {
19                    return false;
20                }
21                st.pop();
22            }
23            st.push(curr);
24        }
25        return st.size() == 1 && st.peek().equals("#");
26    }
27}