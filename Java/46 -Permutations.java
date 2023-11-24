class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private boolean[] vis;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        /*Algorithm: 
        - we can use backtracking here. 
        - we need a method to understand where we've already visited (think of it like a decision tree.) 
        - also need 2 temporary lists, 1 to house current values and another to host the final permutations. 
        - for the backtrack algorithm: 
            --> end loop condition if curr index == length of array 
            --> we keep track of visited numbers using  a boolean array 
            --> if not visited value, then add, change to visited, then recurse to next index. 
            --> after recurse in for loop, remove prev index, reset to false. 
            Note: by default, a boolean array is initialized to false. */
        this.nums = nums;
        vis = new boolean[nums.length];
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int j = 0; j < nums.length; ++j) {
            if (!vis[j]) {
                vis[j] = true;
                t.add(nums[j]);
                dfs(i + 1);
                t.remove(t.size() - 1);
                vis[j] = false;
            }
        }
    }
}