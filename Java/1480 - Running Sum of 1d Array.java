class Solution {
    public int[] runningSum(int[] nums) {
        /*Algorithm:
        - running sum, just += with current element from previous.
        */

        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
        
    }
}