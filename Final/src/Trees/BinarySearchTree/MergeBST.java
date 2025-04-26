package Trees.BinarySearchTree;

import java.util.*;


public class MergeBST {
  
    
    //The Brute Approach is to store all the elements in a list and then sort it and then return it

    //Rather than this flatten the trees to linked list and then merge the list and then return them
    
    public static TreeNode bstToSortedList(TreeNode root) {
        if (root == null) return null;

        TreeNode leftList = bstToSortedList(root.left);
        TreeNode rightList = bstToSortedList(root.right);

        root.left = null;  // Disconnect left child to make it a linked list

        // Merge root with left list
        if (leftList != null) {
            TreeNode temp = leftList;
            while (temp.right != null) temp = temp.right;
            temp.right = root;
        } else {
            leftList = root;
        }
        root.right = rightList; // Connect right subtree

        return leftList;
    }

    // Step 2: Merge Two Sorted Linked Lists
    public static TreeNode mergeSortedLists(TreeNode head1, TreeNode head2) {
        TreeNode dummy = new TreeNode(-1);
        TreeNode current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.right = head1;
                head1 = head1.right;
            } else {
                current.right = head2;
                head2 = head2.right;
            }
            current = current.right;
        }
        if (head1 != null) current.right = head1;
        if (head2 != null) current.right = head2;

        return dummy.right; // Head of merged sorted list
    }

    // Step 3: Convert Sorted Linked List to Balanced BST
    public static TreeNode sortedListToBST(TreeNode head) {
        if (head == null) return null;

        // Find the middle node
        TreeNode slow = head, fast = head, prev = null;
        while (fast != null && fast.right != null) {
            prev = slow;
            slow = slow.right;
            fast = fast.right.right;
        }

        if (prev != null) prev.right = null; // Disconnect left sublist

        TreeNode root = new TreeNode(slow.val);
        if (slow != head) {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(slow.right);
        
        return root;
    }

    // Step 4: Perform Inorder Traversal to Get the List of Integers
    public static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }



    
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // Write your code here.

TreeNode list1 = bstToSortedList(root1);
        TreeNode list2 = bstToSortedList(root2);

        TreeNode mergedList = mergeSortedLists(list1, list2);

        TreeNode mergedBST = sortedListToBST(mergedList);

        List<Integer> result = new ArrayList<>();
        inorderTraversal(mergedBST, result);
        return result;

    }
}
