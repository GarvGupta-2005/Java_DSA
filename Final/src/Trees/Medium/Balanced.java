package Trees.Medium;

public class Balanced {
    public boolean isBalanced(TreeNode root) {
        return dfsHieght(root)!=-1;
    }
    public int dfsHieght(TreeNode root){
        if (root==null){return 0;}//Base case
        int Lh = dfsHieght(root.left);
        if(Lh==-1){return -1;}//if any node has itself an absolute difference then return -1
        int Rh = dfsHieght(root.right);
        if(Rh==-1){return -1;}//Same here 
        if(Math.abs(Lh-Rh)>1){return -1;}//If at current node the left is greater than right or vise versa 
        return Math.max(Lh,Rh)+1;
    }
}
