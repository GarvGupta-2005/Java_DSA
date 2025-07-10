package Trees.Medium;

import java.util.*;


class Solution {

    //This is an optimized DFS code where we just see at each level if the size of arraylist is same as level then we add the value and the priority is given to right side 

    private void helper(TreeNode root,int level,List<Integer> ans){
        if(root == null)return ;

        if(ans.size() == level){
            ans.add(root.val);
        }

        helper(root.right,level+1,ans);
        helper(root.left,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root,0,ans);
        return ans;
    }
}

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
