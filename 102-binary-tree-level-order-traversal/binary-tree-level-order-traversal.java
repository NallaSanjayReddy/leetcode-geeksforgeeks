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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        findit(root,0,list);
        return list;
    }
    public void findit(TreeNode root, int height, List<List<Integer>> list){
        if(root!=null){
            if(list.size()==(height)){
                list.add(new ArrayList<>());
                list.get(height).add(root.val);
                findit(root.left,height+1,list);
                findit(root.right,height+1,list);
            }
            else{
                list.get(height).add(root.val);
                findit(root.left,height+1,list);
                findit(root.right,height+1,list);
            }
        }
    }
}