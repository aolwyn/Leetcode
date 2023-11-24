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
    public TreeNode invertTree(TreeNode root) {
        /*Algorithm: 
        - we want to swap all the children then recursively go into the subtrees and make their swaps.
        - at the end, we return noot. 1 base case for the null value.
        */

        //base case
        if(root == null) return root;

        //swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
       
        //recurse
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
}