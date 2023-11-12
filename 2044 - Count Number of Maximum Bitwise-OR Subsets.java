class Solution {
    private int count;
    private int[] nums;
    private int maxBitwise;
    public int countMaxOrSubsets(int[] nums) {
        /*Algorithm:
        - make some global class related stuff for the returned count and the max bitwise value.
        - calculate max bitwise value
        - use backtracking with 2 paths to check if curr value = when index == size
        */
        maxBitwise = 0;
        this.nums = nums;
        for(int i = 0; i < nums.length; i++){
            maxBitwise |= nums[i];
        }
        backtrack(0, 0);
        return count;
    }

    public void backtrack(int index, int curr){
        if(index == nums.length){
            if(curr == maxBitwise){
                count++;
            }
            return;
        }
            backtrack(index+1, curr | nums[index]);
            backtrack(index+1, curr);
    }
}