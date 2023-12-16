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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*Algorithm:
        We will use recursion. 
        3 base cases -> if both are null, if one is null and other isnt, or the values arent equal.
        after the 3 checks, we can recursively call on the left and right nodes.
        */
        if (p == null && q == null) return true;
        
        if (p == null || q == null) return false;
        
        if (p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }
}