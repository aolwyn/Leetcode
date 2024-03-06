class Solution {
    public int maxCoins(int[] piles) {
        /*Algorithm:
        - we have 3n piles.
        - in each step, alice takes the max. you pick the next max.
        - bob takes the remainder.
        - looking at this, we can understand that it makes sense to always give bob the lowest possible value and then take the remaining highest
        available for you and alice.
        - we can sort and use a 2 pointer technique to solve this.
        */

        if(piles.length ==0 || piles == null)
            return 0;
        
        Arrays.sort(piles);
        int max = 0;
        int left = 0;
        int right = piles.length-2;

        while(left <= right){
            left++;
            max += piles[right];
            right -=2;
        }
        return max;
    }
}