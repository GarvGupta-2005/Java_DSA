package Trees.Medium;

public class Symmetric {
    
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left,root.right);
    }
//The basic nuance of this question is that the left sub tree is mirror image of right sub tree or not
    public boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }

        if(left.val != right.val) return false;

        return isSymmetricHelper(left.left,right.right)&&isSymmetricHelper(left.right,right.left);
    }
}
