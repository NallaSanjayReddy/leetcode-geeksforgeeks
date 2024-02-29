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
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> ptr=new LinkedList<>();
        ptr.add(root);
        return findit(ptr,0);
    }
    public boolean findit(LinkedList<TreeNode> ptr, int level){
        if(ptr.size()==0) return true;
        int n=ptr.size();
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        while(n>0){
            TreeNode root=ptr.poll();
            if(level%2==0){
                if(max<root.val && root.val%2!=0){
                    max=root.val;
                    if(root.left!=null) ptr.add(root.left);
                    if(root.right!=null) ptr.add(root.right);
                }
                else return false;
            }
            else{
                if(min>root.val && root.val%2==0){
                    min=root.val;
                    if(root.left!=null) ptr.add(root.left);
                    if(root.right!=null) ptr.add(root.right);
                }
                else return false;
            }
            n--;
        }
        return findit(ptr,level+1);
        
    }
}