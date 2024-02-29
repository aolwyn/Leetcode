class Solution {
    /*Algorithm:
    - we are given an array of candidates and a target number 'target'
    - we want to find all unique combinations of candidates where the candidate numbers sum to the target
    - however, each # can only be used once.
    - to get the unique combinations, we can use backtracking
    - for the backtracking, end condition is if we've hit the target or if we've surpassed
    - for the unique combinations, we can first sort the array. set the start point to index, check if prev value is same,
    if it is, just continue to next iteration
    - return when done
    */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0)
            return new ArrayList<>();

        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        backtrack(candidates, target, ans, current, 0);

        return ans;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> curr, int index) {
        if(target == 0){
            ans.add(new ArrayList(curr));
        }else if (target < 0) 
            return; 
        else{
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) 
                    continue;

                curr.add(candidates[i]);
                backtrack(candidates, target - candidates[i], ans, curr, i + 1);
                curr.remove(curr.get(curr.size() - 1));
            }
        }
    }
}
