class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*Algorithm:
        - we can take advantage of the fact that the input array has already been sorted.
        - we can use a 2 pointer approach.
        - 1 base case: where there's only 2 numbers given.
        - when the correct indexes have been found, return the index + 1 as we want the number, not index value.
        */

        int left = 0;
        int right = numbers.length-1;

        while(left < right){
            int temp = numbers[right]+numbers[left];
            if(temp == target){
               break;
            }
            else if(temp > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[] {left+1, right+1};
    }
}