package Trees.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder {
    public static void postorder(TreeNode root){
        if(root == null){
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    public static List<Integer> IterativePostOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !st.isEmpty()){
            if(cur!=null){
                st.push(cur);
                cur= cur.left;
            }else{
                 TreeNode temp = st.peek().right;
                 if(temp == null){
                    temp = st.peek();
                    st.pop();
                    res.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.peek();
                        st.pop();
                        res.add(temp.val);
                    }
                 }else{
                    cur = temp;
                 }

            }
        }
        return  res;
    }
}
