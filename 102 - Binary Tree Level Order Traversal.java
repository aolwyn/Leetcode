import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*Algorithm:
        - we are using a BFS because we are going in level order.
        - this implementation will use a queue.

        - major algorithm is as follows:
            --> while the queue isn't empty, grab the size.
            --> initialize a list to hold the values of the level.
            --> for the given length of the queue, poll the value and add it to the list.
            --> if the left / right isn't null, add to queue.
            --> once for loop ends, add level and we go to top.
            --> when nothing left to enqueue, we return.

        - base case, if root is null.
        - Complexities are both O(n)
        */
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return result;

        queue.add(root);

        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < length; i++){
                TreeNode currentNode = queue.poll();
                level.add(currentNode.val);

                if(currentNode.left != null)
                    queue.add(currentNode.left);

                if(currentNode.right != null)
                    queue.add(currentNode.right);
            }
            result.add(level);
        }
        return result;
    }
}