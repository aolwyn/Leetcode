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
    public List<Integer> rightSideView(TreeNode root) {
        /*Algorithm:
        - do a level order traversal, when the size is 1 on remainder, then we can append to right side view?
        - use a queue to hold current level
        */
        if(root == null)
            return new ArrayList<>();
        
        ArrayList<Integer> view = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i < length; i++){
                TreeNode current = queue.poll();
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!= null){
                    queue.add(current.right);
                }
                if(i == length-1){
                    view.add(current.val);
                }
            }
        }
        return view;
    }
}