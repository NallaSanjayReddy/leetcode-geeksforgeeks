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
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> bfs=new LinkedList<>();
        bfs.add(root);
        return findit(bfs);
    }
    public int findit(LinkedList<TreeNode> bfs){
        if(bfs.size()==1){
            TreeNode etr=bfs.peek();
            if(etr.left==null && etr.right==null){
                return etr.val;
            }
        }
        TreeNode etr=bfs.poll();
        if(etr.right!=null) bfs.add(etr.right);
        if(etr.left!=null) bfs.add(etr.left);
        return findit(bfs);
    }
}