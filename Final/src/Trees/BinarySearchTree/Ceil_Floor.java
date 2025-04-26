package Trees.BinarySearchTree;

public class Ceil_Floor {
    public  static int findCeil(TreeNode node, int key) {

        // Write your code here
        if(node == null)return -1;
        int ceil = -1;
        while(node!=null){
            if(node.val == key){
                ceil = node.val;
                return ceil;
            }
            if(node.val < key){
                node = node.right;
            }else{
                ceil = node.val;
                node = node.left;
            }
        }
        return ceil;

    }

    public static int floor(TreeNode root, int x) {
        // Code here
        if(root == null) return -1;
        
        int floor = -1;
        while(root!=null){
            if(root.val == x){
                floor = root.val;
                return floor;
            }
            
            if(root.val > x){
                root = root.left;
            }
            else if(root.val <= x){
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }

    
}
