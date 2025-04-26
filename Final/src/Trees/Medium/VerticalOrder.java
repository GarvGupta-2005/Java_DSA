package Trees.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder {


//This question can be easily xisualised by drawing vertical lines on the nodes and then giving them both row and column and then initialising 
//the required answer using those row and col valuew

    class Tuple {
        TreeNode node;
        int row;
        int col;
        
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Using TreeMap to store nodes according to their column and row
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        // BFS Traversal
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.col;   // Horizontal Level (Column)
            int y = t.row;   // Vertical Level (Row)

            // Insert into TreeMap
            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            // Traverse left and right children
            if (node.left != null) {
                q.offer(new Tuple(node.left, y + 1, x - 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, y + 1, x + 1));
            }
        }

        // Constructing the result
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
        }

        return res;
    }
}