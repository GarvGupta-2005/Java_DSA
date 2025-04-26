package Trees.Medium;

import java.util.*;

public class BottomView {
    public ArrayList <Integer> bottomView(TreeNode root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        // TreeMap to store the first node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int l = p.line;
            TreeNode n = p.node;
            
            map.put(l,n.val);//Putting it inside whether
            
            // Traverse left and right children
            if (n.left != null) {
                q.offer(new Pair(n.left, l - 1));
            }
            if (n.right != null) {
                q.offer(new Pair(n.right, l + 1));
            }
        }
        
        // Collecting values from the sorted map for the top view
        for (Integer value : map.values()) {
            ans.add(value);
        }
        
        return ans;
    }
}
