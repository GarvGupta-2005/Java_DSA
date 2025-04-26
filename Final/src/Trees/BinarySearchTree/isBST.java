package Trees.BinarySearchTree;


class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(TreeNode left,TreeNode right,int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}

public class isBST {
    static boolean isBSTTraversal(int arr[]) {
        // code here
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]>=arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static  TreeNode searchBST(TreeNode root, int val) {
        if(root == null )return null;
        if(root.val == val) return root;
        if(root.val< val) return searchBST(root.right,val);
        if(root.val>val) return searchBST(root.left,val);
        return null;
    }

    int minValue(TreeNode root) {
        // code here  //To find the minimum in BST
        if(root.left == null){
            return root.val;
        }
        return minValue(root.left);
    }


}
