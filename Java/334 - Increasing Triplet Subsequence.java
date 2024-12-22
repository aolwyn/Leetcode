class Solution {
    public boolean increasingTriplet(int[] nums) {
        /*Algorithm:
        - looking to match triplet indexes in increasing order.
        - triplets don't need to be side by side.
        - use greedy algorithm, check locally optimal min value.
            - if less than first, assign first to that. if not less than first, we know its bigger, and could be the new 'second'.
            - if bigger than both, its our third.
        */
        int first, second;
        first = Integer.MAX_VALUE;
        second = Integer.MAX_VALUE;

        int n = nums.length;

        if(nums.length <3) // need at least 3 numbers to consider a triplet.
            return false;

        for(int i =0; i < n; i++){
            if(nums[i] <= first){ // num <= first
                first = nums[i];
            }else if(nums[i] <= second){ // first < num <= second
                second = nums[i];
            }else{
                return true;
            }

        }
        return false;
    }
}