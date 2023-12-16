class Solution {
    public int search(int[] nums, int target) {
        /*algorithm:
        - just do binary search; keep track of middle index and which values.
        - middle index is left bound + (right-left/2)
        - if left and right bound meet, target not in nums, return -1.
        - also ret -1 if length == 0
        */

        if(nums.length == 0) return -1;

        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int middle = left + ((right-left)/2);
            if(nums[middle] == target){
                return middle;
            }else if (nums[middle] > target){
                right = middle-1;
                
            }else{
                left = middle+1;
            }
        }
        return -1;
    }
}