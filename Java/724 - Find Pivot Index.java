class Solution {
    public int pivotIndex(int[] nums) {
        /*Algorithm:
        - take 2 passes on the array, 1 to sum it and then one to check for pivot index.
        - for the second pass, subtract curr element from total (because its to left not including curr index value.) if not equal, incrmeent left sum
        - return -1 if not found.
        */
        int right = 0;
        int left = 0;

        for(int num : nums){
            right+= num;
        }

        for(int i = 0; i < nums.length; i++){
            right-= nums[i];
            if(right == left)
                return i;
            
            left+=nums[i];
        }
        return -1;
    }
}