class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /*Algorithm:
        - effectively, we have a decision tree. need to decide to take a number or not.
        - we will use a backtrack DFS approach. we will call 2 things in our helper function, 
        one call where the next number is taken, and the next where the number is not.
        - we will use an index value to keep track of the current start index.
        - end condition is when youve hit the size of nums compared to start index for list.
        */
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        DFS(ans, 0, nums, list);
        return ans;

    }
    public void DFS(List<List<Integer>> ans, int start, int[] nums, List<Integer> list){
            if(start >= nums.length) //we have hit the end of the array length, meaning a valid solution.
                ans.add(new ArrayList<>(list));
            else{
                // add the element and start the  recursive call
                list.add(nums[start]);
                DFS(ans, start+1, nums, list);
                // remove the element and do the backtracking call.
                list.remove(list.size()-1);
                DFS(ans, start+1, nums, list);
            }
    }
}