package Trees.Medium;

import java.util.*;


class Pair {
    TreeNode node;
    int line;
    
    Pair(TreeNode n, int l) {
        this.node = n;
        this.line = l;
    }
}


public class TopView {
    
    static ArrayList<Integer> topView(TreeNode root) {
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
            
            // Only add the node if it's the first at its horizontal level
            if (!map.containsKey(l)) {
                map.put(l, n.val);
            }
            
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