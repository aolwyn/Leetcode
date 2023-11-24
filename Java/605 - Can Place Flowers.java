class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*Algorithm:
        - think of it like a modified sliding window. 
        - in order to place a flower, the left + right must be 0 and curr must not be 1
        - one weird case to consider, if the edge is at beginning of the flowerbed or at the final element in the bed
        - we check if current element is 0, if it is, then we can check the edges.
        - if the edges are both 0's or at the bounds of the flowerbed, we can do flower placement check
        */
    
        int count = 0;
        int prev = 1;
        int next = 1;
    
        for(int i =0; i < flowerbed.length; i++){
            int curr = flowerbed[i];
            if(curr == 0){
                prev = (i == 0 || flowerbed[i-1] == 0) ? 0 : 1;
                next = ( i== flowerbed.length -1 || flowerbed[i+1] == 0) ? 0 : 1;  
            }
            if(prev == 0 && next == 0){
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n ? true : false;
    }
}