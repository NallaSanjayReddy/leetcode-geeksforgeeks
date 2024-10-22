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
    PriorityQueue<Long> ptr=new PriorityQueue<>();
    LinkedList<TreeNode> queue=new LinkedList<>();
    LinkedList<TreeNode> que=new LinkedList<>();
    public long kthLargestLevelSum(TreeNode root, int k) {
        queue.add(root);
        while(!queue.isEmpty()){
            que=new LinkedList<>(queue);
            queue=new LinkedList<>();
            long sum=0;
            while(!que.isEmpty()){
                TreeNode etr=que.poll();
                sum+=etr.val;
                if(etr.left!=null) queue.add(etr.left);
                if(etr.right!=null) queue.add(etr.right);
            }
            if(ptr.size()==k){
                ptr.add(sum);
                ptr.poll();
            }
            else{
                ptr.add(sum);
            }
        }
        if(ptr.size()<k) return -1;
        else return ptr.peek();
    }
}