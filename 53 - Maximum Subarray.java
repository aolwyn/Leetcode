class Solution {
    public int maxSubArray(int[] nums) {
        /*Algorithm:
        - keep a runnign total of the max with current element + running max against the current element.
        - compare against overall max
        - 1 base case, only 1 number
        */
        if(nums.length ==1) return nums[0];

        int currMax=nums[0];
        int max = nums[0];
        for(int i =1; i < nums.length; i++){
            currMax = Math.max(nums[i]+currMax, nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
        
    }
}