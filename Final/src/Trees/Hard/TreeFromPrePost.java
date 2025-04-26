package Trees.Hard;

public class TreeFromPrePost {
     //This solution is based on the approach that when the node is encountered first time 
    //it is encountered in preorder and when the node is encountered for the third time 
    //it is in the postorder
    //if pre[preIndex] == post[postIndex] then we move both forward else we only move preInd

    int preIndex = 0;
    int postIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode cur = new TreeNode(preorder[preIndex]);
        preIndex++;

        if(cur.val!=postorder[postIndex]){
            cur.left = constructFromPrePost(preorder,postorder);
        }
        if(cur.val!=postorder[postIndex]){
            cur.right = constructFromPrePost(preorder,postorder);
        }
        postIndex++;
        return cur;
    }
}
