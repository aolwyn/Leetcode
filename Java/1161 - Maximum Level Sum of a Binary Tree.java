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
    public int maxLevelSum(TreeNode root) {
        /*Algorithm:
        - do bfs with queue.
        - hold value for curr level, max level sum and then the level where max is found.
        - iterate through TreeNodes until queue is done
        */
        if(root == null)
            return 0;
        
        int max = root.val;
        int level = 1;
        int currLevel = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            currLevel++;
            int length = queue.size();
            int sum = 0;
            for(int i= 0; i < length; i++){
                TreeNode curr = queue.poll();
                sum+=curr.val;
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            if(sum > max){
                level = currLevel;
                max = sum;
            }
        }
        return level;
    }
}