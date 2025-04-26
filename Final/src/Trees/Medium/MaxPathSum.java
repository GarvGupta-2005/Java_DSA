package Trees.Medium;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] sum = new int[1]; // This will hold the global maximum path sum
        sum[0] = Integer.MIN_VALUE; // Initialize to the smallest possible value
        maxGain(root, sum);
        return sum[0];
    }

    public int maxGain(TreeNode root, int[] sum) {
        if (root == null) {
            return 0; // Base case: no contribution from a null node
        }

        // Recursively get the maximum gain from the left and right subtrees
        int leftGain = Math.max(0, maxGain(root.left, sum));
        int rightGain = Math.max(0, maxGain(root.right, sum));

        // Calculate the path sum that passes through the current root
        int currentPathSum = root.val + leftGain + rightGain;

        // Update the global maximum path sum
        sum[0] = Math.max(sum[0], currentPathSum);

        // Return the maximum contribution to the parent node
        return root.val + Math.max(leftGain, rightGain);
    }
}
