package Trees.Traversals;

import java.util.*;

public class BFS_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            List<List<Integer>> cur = new ArrayList<>();
         
            return cur;
            //Handling the base case when the root given itself is null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0;i<levelNum;i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                cur.add(q.poll().val);
            }
            res.add(cur);
        }
        return res;
    }
}
