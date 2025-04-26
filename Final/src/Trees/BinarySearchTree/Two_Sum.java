package Trees.BinarySearchTree;

import java.util.*;

public class Two_Sum {

    //This is the brute Approach
    private void Inorder(TreeNode root,HashMap<Integer,Integer> map){
        if(root == null)return;
        Inorder(root.left,map);
        if(root!=null) map.put(root.val,map.getOrDefault(root.val,0)+1);
        Inorder(root.right,map);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Inorder(root,map);
        for(Integer key : map.keySet()){
           int complement = k - key;
            if (map.containsKey(complement)) {
                if (key != complement || map.get(complement) > 1) {
                    return true;
                }
        }
    }
            return false;
    }

    
    
}
