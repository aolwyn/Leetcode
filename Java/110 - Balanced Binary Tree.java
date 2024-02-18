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
    /*Algorithm:
    - we are trying to determine if the tree is height-balanced, meaning we need to determine if the difference
    in height of the 2 subtrees never differs by more than 1.
    - we can look at this 2 ways, one solution works bottom up or we can use a Pair data structure.
    - bottom up is more intuitive so i'll take that approach using DFS
    - to do this, we can calculate the heights of each subtree using DFS.
    - with this, we can check each subtree and recursively call.

    TL;DR, calculate height of each subtree then move to higher node and check it's subtrees
    -> using DFS

    */
    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight,rightHeight);
    }
}