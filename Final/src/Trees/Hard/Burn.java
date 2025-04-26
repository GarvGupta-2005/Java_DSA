package Trees.Hard;

import java.util.*;

public class Burn {
    //This question is similar to previous one where we have to map the parents of a node i.e KDistanceFromTarget
        public static int minTime(TreeNode root, int target) {
        
        int k=0;
        if(root==null){
            return k;
        }
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        
        parentMethod(parent,root);
        
        Queue<TreeNode> q=new LinkedList<>();
        
        TreeNode t=findTargetNode(root,target);
        
        q.add(t);
        
        HashSet<TreeNode> visited=new HashSet<>();
        
        visited.add(t);
        while (!q.isEmpty()) {
        int n = q.size();
        k++;

        for (int i = 0; i < n; i++) {
            TreeNode temp = q.poll();

           
            if (parent.containsKey(temp) && !visited.contains(parent.get(temp))) {
                q.add(parent.get(temp));
                visited.add(parent.get(temp));
            }

            
            if (temp.left != null && !visited.contains(temp.left)) {
                q.add(temp.left);
                visited.add(temp.left);
            }

            
            if (temp.right != null && !visited.contains(temp.right)) {
                q.add(temp.right);
                visited.add(temp.right);
            }
        }
    }
        return k-1;
        
    }
    
    public static TreeNode findTargetNode(TreeNode root, int target) {
    if (root == null) {
        return null;  // If the tree is empty, return null
    }
    
    // Check if the current node is the target
    if (root.val == target) {
        return root;  // If found, return the current node
    }
    
    // Recursively search in the left and right subtrees
    TreeNode leftResult = findTargetNode(root.left, target);
    if (leftResult != null) {
        return leftResult;  // If the target is found in the left subtree, return it
    }
    
    return findTargetNode(root.right, target);  // Search in the right subtree if not found in the left
}
    
    public static void parentMethod (HashMap<TreeNode,TreeNode>m,TreeNode root){
        
        if(root==null){
            return;
        }
        
        if(root.left!=null){
            m.put(root.left,root);
        }
        
        if(root.right!=null){
            m.put(root.right,root);
        }
        parentMethod(m,root.left);
        parentMethod(m,root.right);
        
        
        
    }
}
