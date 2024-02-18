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

    int result = -1;
    
    public int diameterOfBinaryTree(TreeNode root) {
        /*Algorithm:
        - we are looking to solve for the diameter, the length of the path.
        - we can calculate the sum of heights of left and right subtree.
        - we will initialize the max height to -1 (null height) and then DFS on both; keep note of adding 1 to curr value because need to include cur node
        - for the DFS, compute left and right heights. update the sum of left and right subtrees into result then return the max height of curr node's left and right subtree.
        */

        DFS(root);
        return result; 
    }

    public int DFS(TreeNode root){
        if(root == null)
            return -1;
        
        int left = 1 + DFS(root.left);
        int right = 1 + DFS(root.right);
        result = Math.max(result,(left+right));
        return Math.max(left,right);
    }
}