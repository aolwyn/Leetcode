class Solution {
    public int maxCoins(int[] piles) {
        /*Algorithm:
        - general idea is to pick smallest # and then the 2 highest values in each iteration
        - sort the array first
        - we can 2 pointer. the left pointer increments by one but the right pointer goes by 2
        - for the right pointer, we want to precrement add the value to sum then decrement again after before next iteration.
        */
        if(piles.length < 3)
            return 0;
        
        Arrays.sort(piles);

        int left = 0;
        int right = piles.length-1;
        int sum = 0;

        while(left <= right){
            left++;
            sum+= piles[--right];
            right--;
        }
        return sum;
    }
}