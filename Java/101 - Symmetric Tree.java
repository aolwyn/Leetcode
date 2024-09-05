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
    public boolean isSymmetric(TreeNode root) {
        /*Algorithm:
        - we need to check if it is symmetric, or in other words, mirrored around the middle point.
        - we can use DFS and check the left and right of the root values, check if they are equal
        - because its a mirror, it'll be outer and inner pairing checks
        */
        if(root == null)
            return true;
        
        if(root.left == null && root.right != null || root.left != null && root.right == null)
            return false;

        return isMirror(root.left, root.right);
        
    }

    private boolean isMirror(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        
        if(root1.val != root2.val)
            return false;
        
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);

    }
}