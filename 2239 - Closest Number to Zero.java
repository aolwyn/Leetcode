class Solution {
    public int findClosestNumber(int[] nums) {
        /*Algorithm:
        - we keep track of closest by taking curr value (abs)
        - update running closest accordingly as min of the current vs. stored
            --> we update greatest of abs if both is present
        */

        int closest = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int curr = Math.abs(nums[i]);

            if(curr <= Math.abs(closest)){
                if(curr == Math.abs(closest)){
                    closest = nums[i] > closest ? nums[i] : closest;
                }else{
                    closest = nums[i];
                }    
            }
        }

        return closest;
        
    }
}