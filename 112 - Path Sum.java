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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        /*Algorithm:
        - we will use recursive calls, subtracting root value from targetSum.
        - if the value is 0 and the root's nodes are null, a path exists. otherwise,
        a path is non-existent.
        - recursively call with or checking all paths.
        */
        if(root == null) return false;
        targetSum -=root.val;
        if(targetSum == 0 && root.left == null && root.right == null) return true;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}