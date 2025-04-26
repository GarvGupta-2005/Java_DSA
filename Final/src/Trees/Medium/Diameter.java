package Trees.Medium;

public class Diameter {
    //Left_hieght + right_hieght from any node is called diameter 
    public int diameterOfBinaryTree(TreeNode root) {
        int [] diameter = new int[1];
        height(root,diameter);
        return diameter[0];
    }
    public int height(TreeNode root,int [] diameter){
        if(root==null){return 0;}
        int lh = height(root.left,diameter);
        int rh = height(root.right,diameter);
        diameter[0]  = Math.max(diameter[0],lh+rh);
//This diamater is the global element that stores the sum of height of left and right side if they are maximum and stores the max required answer as at each step we return the maximum height from each node 
        return 1+Math.max(lh,rh);
    }
}
