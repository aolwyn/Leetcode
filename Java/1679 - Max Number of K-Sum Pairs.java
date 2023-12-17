class Solution {
    public int maxOperations(int[] nums, int k) {
        /*Algorithm:
        - we want to try and do this in 1 pass, so no sorting - meaning we can use a hash map.
        - alternatively, we can sort it and then do left and right pointer.
        */
        int count = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == k){
                count++;
                left++;
                right--;
            }else if(sum > k){
                right--;
            }else{
                left++;
            }
        }
       
        return count;
    }
}