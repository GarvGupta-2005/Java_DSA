package Trees.BinarySearchTree;

public class KthSmallest {
    int count = 0;  // Counter to track visited nodes
    int result = -1; // Store the kth smallest value


    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;

        // Traverse the left subtree first (smallest values)
        inorder(root.left, k);

        // Increment count and check if it's the kth node
        count++;
        if (count == k) {
            result = root.val;
            return; // Stop traversal as we've found the kth smallest element
        }

        // Traverse the right subtree
        inorder(root.right, k);
    }
}
