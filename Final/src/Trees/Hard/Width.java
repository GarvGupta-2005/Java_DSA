package Trees.Hard;

import java.util.*;

class Pair{
    TreeNode node;
    int ind;
    Pair(TreeNode node,int ind){
        this.node = node;
        this.ind = ind;
    }
}


public class Width {
    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size  = q.size();
            int min = q.peek().ind;
            int first = 0,last = 0;
            for(int i = 0;i<size;i++){
                int cur_ind = q.peek().ind-min;
                TreeNode node = q.peek().node;
                q.poll();
                if(i == 0){
                    first = cur_ind;
                }
                if(i == size-1){
                    last = cur_ind;
                }
                if(node.left!=null){
                    q.offer(new Pair(node.left,cur_ind*2+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,cur_ind*2+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
}
}
