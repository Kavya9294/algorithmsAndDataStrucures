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
 /*
 max denotes the maximum price of
 taking the full path(left, right, root)
 but at each root, we are taking either the root+left, root+right
 if either left or right <0, then make it 0 and dont even consider it
 */
class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lSum = Math.max(helper(root.left), 0);
        int rSum = Math.max(helper(root.right), 0);
        int sum = root.val + lSum + rSum;
        
        max = Math.max(max, sum);
        
        return root.val + Math.max(lSum, rSum);
    }
}