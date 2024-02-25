class Solution {
    /*Algorithm:
    - we want to find all unique combinations of candidates where chosen numbers sum to a target
    - 2 combinations are unique if the frequency of at least one of the chosen #'s is different
    - we can use a backtrack approach which will allow us to check all possible combinations.
    - we keep track of the current index and 2 recursive calls:
        -> call 1 recurses using the same candidate index
        -> remove last added, and in second call, skip curr index and move to next candidate
    - add the numbers that are valid, end condition if our sum goes too high/low or if out of index bounds.

    */
    private List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();

        backtrack(candidates,target,0,curr);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int index, List<Integer> current){

        if(index >= candidates.length || target < 0){
            return;
        }else if(target == 0){
            ans.add(new ArrayList<>(current));`
            return;
        }else{
            current.add(candidates[index]);
            backtrack(candidates,target-candidates[index],index,current);
            current.remove(current.size()-1);
            backtrack(candidates,target,index+1,current);

        }
    }


    
}