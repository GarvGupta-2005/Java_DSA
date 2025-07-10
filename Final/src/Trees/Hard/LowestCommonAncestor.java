package Trees.Hard;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base Case: If root is null, or if root is either p or q,
        // then root is the LCA (or one of the nodes being searched).
        if(root == null) return root;
        if(root == p || root == q) return root;

        // Recursively search for p and q in left and right subtrees.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null, it means p and q were found
        // in different subtrees. So, root is their lowest common ancestor.
        if(left != null && right != null) {
            return root;
        }

        // If only one side is non-null, return that side.
        // It means both p and q are located in that subtree.
        return (left != null) ? left : right;
    }
}


public class LowestCommonAncestor {
    public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }
        else{
            return root;
        }
    }
}
