/*
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
*/

class Solution {
      boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Function to collect left boundary nodes
    // (top-down order)
     void collectBoundaryLeft(Node root, ArrayList<Integer> res) {
        if (root == null || isLeaf(root))
            return;

        res.add(root.data);
        if (root.left != null)
            collectBoundaryLeft(root.left, res);
        else if (root.right != null)
            collectBoundaryLeft(root.right, res);
    }

    // Function to collect all leaf nodes
     void collectLeaves(Node root, ArrayList<Integer> res) {
        if (root == null)
            return;

        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        collectLeaves(root.left, res);
        collectLeaves(root.right, res);
    }

    // Function to collect right boundary nodes
    // (bottom-up order)
     void collectBoundaryRight(Node root, ArrayList<Integer> res) {
        if (root == null || isLeaf(root))
            return;

        if (root.right != null)
            collectBoundaryRight(root.right, res);
        else if (root.left != null)
            collectBoundaryRight(root.left, res);

        res.add(root.data);
    }
	
  	// Function to find Boundary Traversal of Binary Tree
     ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        // Add root data if it's not a leaf
        if (!isLeaf(root))
            res.add(root.data);

        // Collect left boundary
        collectBoundaryLeft(root.left, res);

        // Collect leaf nodes
        collectLeaves(root, res);

        // Collect right boundary
        collectBoundaryRight(root.right, res);

        return res;
    }

    
}
