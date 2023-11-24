class Solution {
    public int subsetXORSum(int[] nums) {
        /*Algorithm:
         * we backtrack to find all subsets. for each subset, we take current total and XOR with curr element, or choose not to include it.
         * 1 base case, no values in the array (empty array) so return 0
         */
        if(nums.length == 0){
            return 0;
        }
        return backtrack(0, nums, 0);
    }

    public int backtrack(int index, int[] nums, int curr){
        if(index >= nums.length){
            return curr;
        }
        return backtrack(index+1, nums, curr ^ nums[index]) + backtrack(index+1, nums, curr);
    }
}