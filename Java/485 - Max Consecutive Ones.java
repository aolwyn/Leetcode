class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*Algorithm:
        - we can use a sliding window approach. when the left pointer is 1, increment right pointer and current 
        counter until the right pointer either hits the end of the array or a 0 element.
        - at this point, we update the max count and then set the left pointer to the right pointers position.
        */

        int left = 0;
        int right = 0;
        int count = 0;
        int curr = 0;

        while(right < nums.length || left < nums.length){
            if(nums[left]==1){
                while(right < nums.length && nums[right] == 1){
                    right++;
                    curr++;
                }
                count = Math.max(count,curr);
                left = right;
                curr = 0;
            }
            left++;
            right++;
        }
        return count;
    }
}