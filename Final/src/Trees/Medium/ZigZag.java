package Trees.Medium;

import java.util.*;
public class ZigZag {
    //Similar to level order traversal just take a flag which tells us whether we have to traverse from left to right or vice versa
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int flag = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wraplist = new ArrayList<>();
        if(root==null){return wraplist;}
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0;i<levelNum;i++){
                if(queue.peek().left !=null){queue.offer(queue.peek().left);}
                if(queue.peek().right !=null){queue.offer(queue.peek().right);}
                subList.add(queue.poll().val);
            }
            if(flag==0){wraplist.add(subList);}

            else{
             Collections.reverse(subList);
            wraplist.add(subList);
            }

            if(flag==0){flag = 1;}
            else if(flag==1){flag = 0;}

        }
        return wraplist;
    }
}
