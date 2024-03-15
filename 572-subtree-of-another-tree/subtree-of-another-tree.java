class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false; // subRoot is not a subtree of a null tree
        if (isSameTree(root, subRoot)) return true; // Check if trees are identical
        // Check if subRoot is a subtree of either branch
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true; // Both trees are empty
        if (s == null || t == null) return false; // One of the trees is empty
        if (s.val != t.val) return false; // Mismatched values
        // Both trees are non-empty, compare the children
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
