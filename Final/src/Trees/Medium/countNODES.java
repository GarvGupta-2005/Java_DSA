package Trees.Medium;

public class countNODES {
    public static int countNodes(TreeNode root) {
        int count;
        if(root==null){
            count = 0;
            return count;
        }else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
        
    }
}
