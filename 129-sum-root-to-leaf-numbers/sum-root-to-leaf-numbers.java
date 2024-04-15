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
    public int sumNumbers(TreeNode root) {
        return findit(root,0);
    }
    int findit(TreeNode root, int num){
        if(root!=null){
            num=num*10+root.val;
            if(root.left!=null || root.right!=null) return findit(root.left,num) + findit(root.right,num);
            else return num;
        }
        return 0;
    }
}