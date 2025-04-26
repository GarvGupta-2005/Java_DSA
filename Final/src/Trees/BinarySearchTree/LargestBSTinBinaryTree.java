package Trees.BinarySearchTree;


class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}




public class LargestBSTinBinaryTree {
    static class NodeValue {
        public int maxNode, minNode, maxSize;
        
        NodeValue(int maxNode, int minNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }
    
    public static NodeValue largestBSTSubtree(Node root) {
        if (root == null) {
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        
        // Get values from left and right subtrees
        NodeValue left = largestBSTSubtree(root.left);
        NodeValue right = largestBSTSubtree(root.right);
        
        // Check if the current tree is a BST
        if (left.maxNode < root.data && root.data < right.minNode) {
            // It's a valid BST
            return new NodeValue(Math.max(root.data, right.maxNode), 
                                 Math.min(root.data, left.minNode), 
                                 left.maxSize + right.maxSize + 1);
        }
        
        // Not a BST, return max size found so far
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        return largestBSTSubtree(root).maxSize;
    }
}
