class Solution {
    public int maxArea(int[] height) {
        /*Algorithm:
        - we will use a 2 pointer approach with a greedy algorithm to get the highest bounds possible.
        - we will take the max of the current max area and then the smaller height of the 2 bounds multiplied by the    length.
        - 1 base case, if there's only 1 or none given (cant make container with 1 edge)
        */
        if(height.length <= 1) return 0;
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while(left < right){
            //2 cases: if the left bound is lower or if the right bound is lower. Always want to keep the higher of the 2 where it is so we can just increment / decrement the other accordingly.
            if(height[left] < height[right]){
                maxArea = Math.max(maxArea, height[left] *(right-left));
                left++;
            }else{
                maxArea = Math.max(maxArea, height[right] *(right-left));
                right--;
            }
        }
        return maxArea;
    }
}