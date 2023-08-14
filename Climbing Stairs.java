class Solution {
    public int climbStairs(int n) {
        /*Algorithm:
        - We notice that the current step is the sum of the previous two steps.
        - We can populate an array of N+1 size.
        - the first 2 elements in the array will be the 0 and 1 layers.
        - 1 base case, where n <= 1.
        */

        if(n <= 1) return 1;

        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;

        for(int i = 2; i <= n; i++){
            steps[i]  = steps[i-1] + steps[i-2];
        }
        return steps[n];
        
    }
}