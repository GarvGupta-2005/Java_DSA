package Trees.BinarySearchTree;

import java.util.ArrayList;

public class validate {
    //This is the better approach 
     public void inOrder(TreeNode root,ArrayList<Integer> ans){
        if(root==null){
            return ;
        }
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> in = new ArrayList<>();
        inOrder(root,in);
        for(int i = 1;i<in.size();i++){
            if(in.get(i-1)>=in.get(i)){
                return false;
            }
        }
        return true;
    }


    //This is the optimal approach
     //In this approach we will pass some ranges for each node as each node shoukd lie between some range 
    //Of they do not then its not A BST
    public boolean isValidBST1(TreeNode root) {
        return isValidBST1(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST1(TreeNode root,long min , long max){
        if(root == null )return true;
        if(root.val>=max || root.val<=min)return false;
        return isValidBST1(root.left,min,root.val)&&isValidBST1(root.right,root.val,max);
    }
}
