class Solution {
    public int dominantIndex(int[] nums) {
        /*Algorithm:
        - 2 ways to think of this,
        - we can either sort and check the 2 highest values or
        - go O(n) and then check at the end.
        - Will go with the O(N);
            --> store values of first 2 numbers into 2 integers
            --> if curr index is > biggest, update a and b
            --> if curr index is > second biggest, update b
            --> update index only when a gets updated
            --> start for loop from index 0 rather than 2.
        */
        int a = Math.min(nums[0],nums[1]);
        int b = Math.max(nums[0],nums[1]);
        int index = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i] >= a){
                int temp = a;
                a = nums[i];
                b = temp;
                index = i;
            }else if(nums[i] > b){
                b = nums[i];
            }else{}
        }
        return (a >= (b*2) ? index : -1);
    }
}