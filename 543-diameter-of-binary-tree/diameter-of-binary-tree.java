/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        findit(root,1);
        return max;
    }
    public int findit(TreeNode root, int height){
        if(root!=null){
            int height1=findit(root.left,height+1);
            int height2=findit(root.right,height+1);
            max=Math.max(max,(height1+height2-2*(height)));
            return Math.max(height1,height2);
        }
        return height-1;
    }
}