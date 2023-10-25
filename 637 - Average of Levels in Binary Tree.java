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
    public List<Double> averageOfLevels(TreeNode root) {
        /*Algorithm:
        - we want the average of levels in a binary tree, so we will be using BFS.
        - we need a queue implementation
        - Major algorithm is as follows:
            --> add root / node to queue.
            --> save length of queue at start of loop. this is loop condition to make sure we dont add child nodes.
            --> pop a node from the queue. for each node, add value to running total of level.
            --> when nothing else at this level, append sum / length of queue (# nodes in level) to the list.
            --> end condition when nothing left.

        - O(n) complexity (visit each node once, store each once in queue)
        - 1 base case, null root
        */
        List<Double> result = new LinkedList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            double sum = 0;
            int length = queue.size();
            for(int i =0; i < length; i++){
                TreeNode current = queue.poll();
                sum += current.val;
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            result.add(sum/length);
        }
        return result;
    }
}