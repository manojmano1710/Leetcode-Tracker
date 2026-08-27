// Last updated: 27/08/2026, 10:27:35
1import java.util.Stack;
2
3class MyQueue {
4
5    Stack<Integer> stack1;
6    Stack<Integer> stack2;
7
8    public MyQueue() {
9        stack1 = new Stack<>();
10        stack2 = new Stack<>();
11    }
12
13    public void push(int x) {
14        stack1.push(x);
15    }
16
17    public int pop() {
18        moveElements();
19        return stack2.pop();
20    }
21
22    public int peek() {
23        moveElements();
24        return stack2.peek();
25    }
26
27    public boolean empty() {
28        return stack1.isEmpty() && stack2.isEmpty();
29    }
30
31    private void moveElements() {
32        if (stack2.isEmpty()) {
33            while (!stack1.isEmpty()) {
34                stack2.push(stack1.pop());
35            }
36        }
37    }
38}