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
    ArrayList<String> arr=new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        findit(root,"");
        Collections.sort(arr);
        return arr.get(0);
    }
    public void findit(TreeNode root, String str){
        str=((char)('a'+root.val))+str;
        if(root.left==null && root.right==null){
            arr.add(str);
        }
        String str1=new String(str);
        if(root.left!=null) {
            findit(root.left,str);
        }
        if(root.right!=null){
            findit(root.right,str1);
        }
    }
}