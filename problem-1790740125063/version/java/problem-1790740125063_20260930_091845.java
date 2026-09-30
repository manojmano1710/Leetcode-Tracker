// Last updated: 30/09/2026, 09:18:45
1class Solution {
2
3    public TreeNode deleteNode(TreeNode root, int key) {
4
5        // If the tree is empty, there is nothing to delete
6        if (root == null) {
7            return null;
8        }
9
10        // If key is smaller than root value,
11        // search in the left subtree
12        if (key < root.val) {
13            root.left = deleteNode(root.left, key);
14        }
15
16        // If key is greater than root value,
17        // search in the right subtree
18        else if (key > root.val) {
19            root.right = deleteNode(root.right, key);
20        }
21
22        // key == root.val
23        // We have found the node that needs to be deleted
24        else {
25
26            // Case 1: Node has no left child
27            // Replace it with its right child
28            if (root.left == null) {
29                return root.right;
30            }
31
32            // Case 2: Node has no right child
33            // Replace it with its left child
34            if (root.right == null) {
35                return root.left;
36            }
37
38            // Case 3: Node has two children
39
40            // Find the smallest node in the right subtree
41            // This is called the inorder successor
42            TreeNode successor = findMin(root.right);
43
44            // Copy the successor's value into the current node
45            root.val = successor.val;
46
47            // Delete the original successor node
48            root.right = deleteNode(root.right, successor.val);
49        }
50
51        // Return the updated root
52        return root;
53    }
54
55    // Finds the smallest node in a subtree
56    private TreeNode findMin(TreeNode root) {
57
58        // The smallest value in a BST is the leftmost node
59        while (root.left != null) {
60            root = root.left;
61        }
62
63        return root;
64    }
65}