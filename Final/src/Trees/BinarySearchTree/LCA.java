package Trees.BinarySearchTree;

public class LCA {
    //For a BST the LCA of the two nodes become ehere either the nodes separate or when one node does not have
    // either left or right to travel
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null )return null;
        int cur = root.val;
        if(cur<p.val && cur<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(cur>p.val && cur>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
