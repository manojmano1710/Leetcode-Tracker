// Last updated: 01/09/2026, 15:06:42
1class NestedIterator implements Iterator<Integer> {
2
3    Stack<NestedInteger> stack = new Stack<>();
4
5    public NestedIterator(List<NestedInteger> nestedList) {
6
7        // Push elements in reverse order
8        for (int i = nestedList.size() - 1; i >= 0; i--) {
9            stack.push(nestedList.get(i));
10        }
11    }
12
13    @Override
14    public Integer next() {
15        return stack.pop().getInteger();
16    }
17
18    @Override
19    public boolean hasNext() {
20
21        // Keep expanding lists until the top is an integer
22        while (!stack.isEmpty()) {
23
24            NestedInteger top = stack.peek();
25
26            if (top.isInteger()) {
27                return true;
28            }
29
30            // Remove the list
31            stack.pop();
32
33            // Get its elements
34            List<NestedInteger> list = top.getList();
35
36            // Push them in reverse order
37            for (int i = list.size() - 1; i >= 0; i--) {
38                stack.push(list.get(i));
39            }
40        }
41
42        return false;
43    }
44}