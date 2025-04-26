package Trees.BinarySearchTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BSTfromPreorder {

    //This is the brute force
     public TreeNode bstFromPreorder(int[] preorder) {
        int [] inorder = new int[preorder.length];
        for(int i = 0;i<preorder.length;i++){
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        return buildTree(preorder,inorder);
    }

    public   TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public  TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]); // Root is always the first element of preorder
        int inRoot = inMap.get(root.val); // Index of root in inorder
        int numsLeft = inRoot - inStart;  // Number of nodes in left subtree

        // Fix in the recursive call for left subtree
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }


     //In this optimal Approach we will be passing range values for each node like we did in the validate BST problem
     public TreeNode bstFromPreorder1(int[] pre) {
        return bstFromPreorder1(pre,Integer.MAX_VALUE,new int[]{0});
    }

    public TreeNode bstFromPreorder1(int [] A,int bound,int [] i){
        if(i[0] == A.length || A[i[0]]>bound)return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = bstFromPreorder1(A,root.val,i);
        root.right = bstFromPreorder1(A , bound , i);
        return root;
    }
}
