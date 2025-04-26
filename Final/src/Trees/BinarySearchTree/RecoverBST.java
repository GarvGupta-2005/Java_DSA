package Trees.BinarySearchTree;

public class RecoverBST {
    private TreeNode first;
    private TreeNode middle;
    private TreeNode prev;
    private TreeNode last;

    private void Inorder(TreeNode root){
        if(root == null)return;

        Inorder(root.left);

        if(prev!=null && root.val<prev.val){
            //if this is the first violation then mark these two
            if(first == null){
                first = prev;
                middle = root;
            }
            else{ //Second violation; mark current node as last
            last = root;
            }
        }
        //mark this node as prev;
        prev = root;
        Inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev  = new TreeNode(Integer.MIN_VALUE);
        Inorder(root);
        if(first!=null && last!=null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }else if(first!=null && middle!=null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}
