package Trees.Hard;

import java.util.*;

public class KDistanceFromTarget {
    //The Algorith we will follow here will include first finding the node of value target
    //Then we will radially move in all directions with it and keep storing the nodes visited in a hash map 
    //Whenever we move away from the target node such that the current node is at a distance k we add it to our list

    private static  void markParents(TreeNode root,Map<TreeNode,TreeNode>parent,TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            if(current.left!=null){
                parent.put(current.left,current);
                q.offer(current.left);
            }
             if(current.right!=null){
                parent.put(current.right,current);
                q.offer(current.right);
            }
        }
    }
    public static  List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        markParents(root,parent,root);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int cur_level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(cur_level == k) break;
            cur_level++;
            for(int i = 0;i<size;i++){
                TreeNode cur = q.poll();
                if(cur.left!=null && visited.get(cur.left)==null){
                    q.offer(cur.left);
                    visited.put(cur.left,true);
                }
                if(cur.right!=null && visited.get(cur.right)==null){
                    q.offer(cur.right);
                    visited.put(cur.right,true);
                }
                if(parent.get(cur)!=null && visited.get(parent.get(cur))==null){
                    q.offer(parent.get(cur));
                    visited.put(parent.get(cur),true);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
}
