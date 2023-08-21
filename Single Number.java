class Solution {
    public int singleNumber(int[] nums) {
        /*Algorithm:
        - recognize that each will appear twice, and given linear runtime,
        we can take advantage of exclusive OR operation.
        */
        int num = 0; 
        for(int i = 0; i < nums.length; i++){
            num ^= nums[i];
        }
        return num;
    }
}