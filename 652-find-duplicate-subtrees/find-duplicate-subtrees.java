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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        
        dfs(root, new HashMap<>(), result);

        return result;
    }

    public String dfs(TreeNode root, Map<String, Integer> frequencies, List<TreeNode> result) {
        if(root == null)
            return "#";

        String subTree = root.val + "," + dfs(root.left, frequencies, result) + "," + dfs(root.right, frequencies, result);

        int frequency = frequencies.getOrDefault(subTree, 0);

        frequencies.put(subTree, ++frequency);

        if(frequency == 2)
            result.add(root);
        
        return subTree;
    }
}