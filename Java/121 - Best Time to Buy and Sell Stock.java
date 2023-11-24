class Solution {
    public int maxProfit(int[] prices) {
        /*Algorithm:
        - stonks = buy low sell high.
        - need one variable to keep track of the min value and another to get max profit.
        - we constantly check the price - min value and see if better than current profit.
        - we also check to see if current minvalue needs to be updated
        */
        int runningProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minValue){
            minValue = prices[i];    
            }else if(prices[i]-minValue > runningProfit){
                runningProfit = prices[i]-minValue;
            }  
        }
    return runningProfit;
    }
}