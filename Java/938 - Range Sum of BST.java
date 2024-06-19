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
    - perform search, any values within the range add to sum ret when done
    */
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {

        if(root == null)
            return 0;
        if(root.val >= low && root.val <= high)
            sum +=root.val;
        
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
        return sum;
        
    }
}