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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return findit(root,target);
    }
    TreeNode findit(TreeNode root, int target){
        if(root!=null){
            TreeNode vall=findit(root.left,target);
            TreeNode valr=findit(root.right,target);
            if(root.val==target && vall==null && valr==null) return null;
            if(vall==null) root.left=vall; 
            if(valr==null) root.right=valr;
            return root;
        }
        return null;
    }
}