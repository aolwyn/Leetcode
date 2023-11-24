class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*Algorithm:
        - we use a sliding window / count approach.
        - count the 1's until 0 appears, take the max of curr window vs. prev highest.
        - return count.
        - 1 special case to consider, if last value is 1 need to update count before returning.
        */
        int count = 0;
        int curr = 0;

        for(int i =0; i < nums.length; i++){
            if(nums[i] == 1){
                curr++;
            }else{
                count = Math.max(count,curr);
                curr =0;
            }
        }
        count = Math.max(count,curr);
        return count;
    }
}