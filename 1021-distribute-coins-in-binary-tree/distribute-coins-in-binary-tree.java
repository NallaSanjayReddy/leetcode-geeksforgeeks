class Solution {
    int ans = 0; 

    public int distributeCoins(TreeNode root) {
        distribute(root);
        return ans;
    }

    public int distribute(TreeNode root) {
        if (root == null) return 0;

        int left = distribute(root.left);
        int right = distribute(root.right);

        // 'ans' will accumulate the total number of moves required
        ans += Math.abs(left) + Math.abs(right);

        // Return the number of coins that need to be passed up to the parent
        // This is the total coins at this node and its subtrees minus 1 (the coin that needs to stay)
        return root.val + left + right - 1;
    }
}
