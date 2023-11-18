class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private boolean[] vis;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        /*Algorithm:
        - We are asked to create a list of all possible permutations.
        - However, we can have duplicates from our source.
        - we still use backtracking with an end condition of index val = size of input array.
            --> major part:
                - we check in the loop if we have visited the element OR..
                - if we arent at first element and the curr element is the same as the previous and we've visited the previous value, we skip this part of the loop.
                - if either of above are true, we skip this run through the loop.
        */
        if(nums.length ==0 || nums == null)
            return ans;

        Arrays.sort(nums);
        this.nums = nums;
        vis = new boolean[nums.length];
        backtrack(0);
        return ans;
    }
    public void backtrack(int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(t));
            return;
        }

        for(int j = 0; j < nums.length; j++){ //check if we have visited the curr element or, if we arent at first element and the curr element is the same as the previous and we've visited the previous value, we skip this part of the loop.
            if(vis[j] || (j > 0 && nums[j] == nums[j-1] && !vis[j-1])){
                continue;
            }
            vis[j] = true;
            t.add(nums[j]);
            backtrack(i+1);
            t.remove(t.size()-1);
            vis[j] = false;

        }
    }
}