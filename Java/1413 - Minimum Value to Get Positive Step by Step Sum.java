class Solution {
    public int minStartValue(int[] nums) {
        /*Algorithm:
        - we keep track of a current running sum.
        - we can keep track of the min value needed by comparing against highest possible integer value against the current sum.
            --> this allows us to keep track of lowest possible running step-by-step sum.
        - once done, we can return the highest of 1 and 1 - min. we do 1 incase no additional support was needed, and 1 - min because negative values make it go +.
        */
        int curr = 0;
        int min  = Integer.MAX_VALUE;

        for(int i =0; i< nums.length; i++){
            curr += nums[i];
            min = Math.min(min, curr);
        }
        return Math.max(1, 1-min);
        
    }
}