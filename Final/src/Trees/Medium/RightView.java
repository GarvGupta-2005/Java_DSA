package Trees.Medium;

import java.util.*;

public class RightView {
    //The key solution is BFS or levelorder traversal
    //At each level we will add all the values on that level and in the final answer
    //we will add the last element of each level 
    //This will give us the right view of tree
    //for left view we will add the first value
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            List<Integer> cur = new ArrayList<>();
            return cur;
            //Handling the base case when the root given itself is null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0;i<levelNum;i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                cur.add(q.poll().val);
            }
            res.add(cur.get(cur.size()-1));
        }
        return res;
    }
}
