/**
 * Definition for a binary tree node.
 * rootublic class TreeNode {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /*Algorithm:
        - need to determine if the second parameter is a subtree of first parameter.
        - identify the sub problems,
            -> search for same root value / check all nodes.
            -> sub problem of isSameTree
        - if root is null means no tree to check against, so return false.
        - otherwise, check left and right subtrees while sending root and subroot to helper function.
        - in helper function, check if root + subroot are null, if not, check value against both sub trees.


        */
        if (root == null) {
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == subRoot;
        }
        return root.val == subRoot.val && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}