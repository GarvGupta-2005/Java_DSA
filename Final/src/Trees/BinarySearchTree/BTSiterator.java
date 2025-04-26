package Trees.BinarySearchTree;

import java.util.*;

class BSTIterator {
    //We will be using a Stack based operations to get the inorder of the tree and return the answer in O(1)
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAll(root);
    }
    //we will keep pushing all the left values in order to get the inorder traversal
    //If the node has no left or right then we go to the prior node to iterate on right
    public int next() {
        TreeNode temp = st.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            node = node.left;
        }
    }

}

public class BTSiterator {
    
}
