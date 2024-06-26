class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        iterate(root, arr);
        return buildTree(arr, 0, arr.size() - 1);
    }

    public void iterate(TreeNode root, ArrayList<TreeNode> arr) {
        if (root != null) {
            iterate(root.left, arr);
            arr.add(root);
            iterate(root.right, arr);
        }
    }

    public TreeNode buildTree(ArrayList<TreeNode> arr, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode node = arr.get(mid);
        
        // Recursively construct the left subtree and attach to the root
        node.left = buildTree(arr, start, mid - 1);
        // Recursively construct the right subtree and attach to the root
        node.right = buildTree(arr, mid + 1, end);
        
        return node;
    }
}
