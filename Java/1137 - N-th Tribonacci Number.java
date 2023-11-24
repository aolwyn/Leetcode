class Solution {
    public int tribonacci(int n) {
        /*Algorithm:
        - we can use memoization with an array to keep track of previous values.
        - we will pre-populate the first 3 values (0,1,1).
        - Note: array will be size + 1 because of 0 index
        */

        //3 base cases for original values..
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for(int i = 3; i < n+1; i++){
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        return memo[n];
    }
}