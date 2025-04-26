package Trees.Medium;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(TreeNode left,TreeNode right,int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

public class Height {
    public static int hieght(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(hieght(root.left),hieght(root.right));
    }
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return hieght(root);
    }
}
