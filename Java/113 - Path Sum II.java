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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        /*Algorithm:
        - we want to find all valid paths for a given target sum, root to leaf.
        - As we want to find all possibilities, we can use recursion or backtracking.
        - major backtracking is as follows:
            -> base case is root null, return
            -> subtract current value from remaining sum
            -> if equal to 0 (we've summed to targetSum) and the leaves are null, we have a valid path.
                --> add new list of curr
            -> otherwise, not at 0 yet, so DFS on both subtrees.
            -> after exploring both subtrees, remove the node from the list.

        */
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        DFS(root, targetSum, curr, ans);
        return ans;
    }

    private void DFS(TreeNode root, int remainingSum, List<Integer> curr, List<List<Integer>> ans){
        if(root == null)
            return;

        remainingSum-= root.val;
        curr.add(root.val);
        if(remainingSum == 0 && root.left == null && root.right == null){
            ans.add(new ArrayList<>(curr));
        }else{
            DFS(root.left, remainingSum, curr, ans);
            DFS(root.right, remainingSum, curr, ans);
        }
        curr.remove(curr.size()-1);
    }
}