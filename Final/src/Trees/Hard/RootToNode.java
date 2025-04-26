package Trees.Hard;

import java.util.*;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.left = null;
        this.right = null;
        this.val = val;
    }
    TreeNode(TreeNode left,TreeNode right,int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

public class RootToNode {
    public static void helper(TreeNode root, ArrayList<ArrayList<Integer>> res, LinkedList<Integer> cur) {
        if (root == null) return;

        cur.add(root.val);

        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(cur));  // Store the current path
        } else {
            if (root.left != null) helper(root.left, res, cur);
            if (root.right != null) helper(root.right, res, cur);
        }

        cur.removeLast();  // Backtracking step
    }

   
    
    
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
                helper(root, res, new LinkedList<>());
return res;
        
    }
}
