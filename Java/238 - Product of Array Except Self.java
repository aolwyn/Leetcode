class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*Algorithm:
        - compute a left and right prefix array. for curr array val just mul by L + R arr values.
        - we can do the right one using a single variable to save space.
        - 2 special cases, the border elements.
        */
        if(nums.length == 0 || nums == null)
            return new int[] {};
        
        int ret[] = new int[nums.length]; //holds the value of left before doing second pass
        ret[0] = 1; //base case needed to do first pass :)

        for(int i = 1; i < nums.length; i++){
            ret[i] = ret[i-1] * nums[i-1];
        }

        int right = 1; //equivalent to doing ret[nums.length-1] and using a new array to compute right product

        for(int j = nums.length-1; j >= 0; j--){
            ret[j] = right * ret[j];
            right *= nums[j];
        }

        return ret;
        
    }
}