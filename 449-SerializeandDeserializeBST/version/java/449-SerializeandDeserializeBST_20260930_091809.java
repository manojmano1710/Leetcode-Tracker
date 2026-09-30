// Last updated: 30/09/2026, 09:18:09
1public class Codec {
2
3    private int index = 0;
4
5    // Serialize
6    public String serialize(TreeNode root) {
7
8        StringBuilder sb = new StringBuilder();
9        preorder(root, sb);
10
11        return sb.toString();
12    }
13
14    private void preorder(TreeNode root, StringBuilder sb) {
15
16        if (root == null)
17            return;
18
19        sb.append(root.val).append(",");
20
21        preorder(root.left, sb);
22        preorder(root.right, sb);
23    }
24
25    // Deserialize
26    public TreeNode deserialize(String data) {
27
28        if (data.isEmpty())
29            return null;
30
31        String[] arr = data.split(",");
32
33        index = 0;
34
35        return build(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
36    }
37
38    private TreeNode build(String[] arr, int min, int max) {
39
40        if (index == arr.length)
41            return null;
42
43        int val = Integer.parseInt(arr[index]);
44
45        if (val < min || val > max)
46            return null;
47
48        index++;
49
50        TreeNode root = new TreeNode(val);
51
52        root.left = build(arr, min, val);
53
54        root.right = build(arr, val, max);
55
56        return root;
57    }
58}