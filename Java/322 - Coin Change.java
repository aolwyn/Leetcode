public class Solution {
    public int coinChange(int[] coins, int amount) {
        /*Algorithm:
        - Greedy algorithm does not work here, so we will be using a dynamic programming approach. Greedy doesnt work because a smaller value coin combo could make a more efficient change result.
        - so because we can't work top down, we will need to work bottom up; solving every value up to the amount,
         counting the min. meaning, we need a cache or some form of memoization
        - base case, no coins or amount is 0
        */

        if(amount == 0 || coins.length == 0 || coins == null) return 0;
        
        int[] memo = new int[amount+1]; //need amount + 1 because 0 is counted.
        Arrays.fill(memo, amount+1); //fill with amount + 1 because it's technically the highest possible value and we want min
        memo[0] = 0;

        //loop for each value until amount, check each coin value. if we can make change (non neg val) then update min cost
        for(int i = 1; i < amount +1; i++){
            for(int coin : coins){
                if(i - coin >= 0)
                    memo[i] = Math.min(memo[i], 1 + memo[i - coin]); // we use 1+ because we use the current coin + the prev calculated value.
            }
        }
        return memo[amount] != amount+1 ? memo[amount] : -1;
    }
} 
    

