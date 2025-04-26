package Trees.BinarySearchTree;

public class Insert_Delete {
    public static  TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);//cretaing a new BST if the prior one was not initialized

        TreeNode cur = root;//creating a new alias since we need to return the root
        while(true){
            if(cur.val <= val){//node should lie on right
            if(cur.right!=null) cur = cur.right;
            else{
                cur.right = new TreeNode(val);
                break;
            }
            }else{//node lies on the left side of root
                if(cur.left!=null) cur = cur.left;
                else{
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root; 
    }




    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;//No BST exist so retun null;
        if(root.val == key){
            return helper(root);
        }
        TreeNode dummy = root;
        while(root!=null){
            if(root.val>key){//The node to delete lies on the left
                if(root.left!=null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                if(root.right!=null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    public TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }else{
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    public TreeNode findLastRight(TreeNode root){
        if(root.right == null){
            return root;
        }
        return findLastRight(root.right);
    }
}
