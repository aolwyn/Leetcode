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
    public int minDepth(TreeNode root) {
        /*Algorithm:
        - the min level is = to the level which has no children.
        - we need a queue
					--> if current node's children are both null, return level +1
        */
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        int min = 1;
        queue.add(root);

        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i =0; i < length; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
                if(curr.left == null && curr.right == null)
                    return min++;

            }
            min++;
        }
        return min;
    }
}