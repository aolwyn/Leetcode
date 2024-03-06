class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        /*Algorithm:
        - we are looking  to maximize a possible score, so likely using a sort
        - if we are sorting, we can use a 2 pointer technique
        - the idea is to claim the highest value tokens while subtracting the lowest possible tokens, thereby maximizing score.
        - so use 2 pointers, the left to keep track of values to subtract, the right for values to get
        - if we have enough power, reduce the token at left and increment score
        - if not enough power but we have a score >= 1, then we can get some more power but lose score.
        - if neither condition is true, break, then return the maxScore.
        */
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;
        int left = 0;
        int right = tokens.length-1;

        while(left <= right){
            if(tokens[left] <= power){
                power -= tokens[left];
                score++;
                maxScore = Math.max(maxScore, score);
                left++;
            }else if(score >= 1){
                power +=tokens[right];
                score--;
                maxScore = Math.max(maxScore, score);
                right--;
            }else{
                break;
            }
        }
        return maxScore;
    }
}