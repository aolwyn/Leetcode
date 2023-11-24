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
    public TreeNode searchBST(TreeNode root, int val) {
        /*Algorithm:
         - we can use recursion and search the tree accordingly.
         - 3 cases:
         1. if current root value = the target or if it's null.
         2. value is less than current root value, go left
         3. otherwise go right because value is greater than current root value.
         - iterate recursively.
         */
        if(root == null || root.val == val)
            return root;
        
        else if(val < root.val){
            return searchBST(root.left, val);
        }
        else{
            return searchBST(root.right,val);
        }
    }
}