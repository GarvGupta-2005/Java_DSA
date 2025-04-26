package Trees.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class Preorder {
    public static void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> iterative_preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        if(root == null) return pre;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
    //we will first push right as we need left node first and that will be accessed by peek
    while(!st.isEmpty()){
        root = st.pop();
        pre.add(root.val);
        if(root.right!=null){
            st.push(root.right);
        }
        if(root.left!=null){
            st.push(root.left);
        }
    }
    return pre;
    }
}
