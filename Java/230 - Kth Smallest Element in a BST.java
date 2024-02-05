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
    public int kthSmallest(TreeNode root, int k) {
        /*Algorithm and thoughts:
        - we are working with a BST.
        - we want to get the kth smallest value (1-indexed.)
        - so we need a method of keeping track of all the nodes that've been visited,
        and a way to keep track of numerical order.
        - We can keep track of the nodes visited using an arraylist.
        - and to get the nodes in numerical order, we can use an in-order traversal which
        will allow us to effectively see all nodes, well, in order.

        to solve this recursively, we will use a helper function.
        */
        if(root == null)
            return 0;
        
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k-1); //return k-1 because its 0 indexed for the arraylist.
    }

    //inorder goes left --> root --> right
    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}