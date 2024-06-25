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
    int val=0;
    public TreeNode bstToGst(TreeNode root) {
        TreeNode head=new TreeNode();
        findit(root,head);
        return head;
    }
    public void findit(TreeNode root, TreeNode head){
        if(root.right!=null){
            head.right=new TreeNode();
            findit(root.right,head.right);
        }
        val+=root.val;
        head.val=val;
        if(root.left!=null){
            head.left=new TreeNode();
            findit(root.left,head.left);
        }
    }
}