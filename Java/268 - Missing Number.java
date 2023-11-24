class Solution {
    public int missingNumber(int[] nums) {
        /*Algorithm:
        - if we sum all numbers in a range and subtract the same amount, we should get back to 0. 
        - using this property, we can essentially use the fact that theres no duplicates and add i and subtract the current value.

        alternatively, we can use bit manipulation and XOR:
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; ++i) {
            ans ^= (i ^ nums[i]);
        }
        return ans;
        */
        int missing = nums.length;
        for(int i =0; i < nums.length; i++){
            missing += i - nums[i];
        }
        return missing;
    }
}