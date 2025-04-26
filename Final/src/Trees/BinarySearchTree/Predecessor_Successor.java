package Trees.BinarySearchTree;

public class Predecessor_Successor {
    public static void findPreSuc(TreeNode root, TreeNode[] pre, TreeNode[] suc, int key) {
        if(root==null){
            return;
        }
        
        findPreSuc(root.left, pre, suc, key);
        
        if(root.val > key){
            if(suc[0] == null || (suc[0] != null && suc[0].val > root.val)){
            suc[0] = root;
            }
        }else if(root.val < key){
            pre[0] = root;
        }
        
        findPreSuc(root.right, pre, suc, key);
    }
}
