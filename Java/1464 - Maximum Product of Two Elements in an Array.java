class Solution {
    public int maxProduct(int[] nums) {
        /*Algorithm:
        - recognize that we are effectively looking for the 2 largest numbers
        - option 1 is to sort array then just take last 2 elements
        - option 2 is to 2 O(n) search array for 2 highest values.
        */
        if(nums.length == 0 || nums == null)
            return 0;
        
        int big = 0;
        int small = 0;

        for(int num : nums){
            if(num > big){
                small = big;
                big = num;
            }else if(num > small){
                small = num;
            }
        }
        return (big-1)*(small-1);
    }
}