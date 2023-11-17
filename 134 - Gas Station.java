class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*Algorithm:
        - we are dealing with a cycle 
        - need to find the start of the cycle. 
        - Loop through the gas station, and track the possible starting index.
        - Start from i = 0, use a second pointer move to track how far we are travelling
        - calculate: remain += gas[i] - cost[i].
        - if remain < 0, fail. This mean: with all remain gas before index i + gas[i], we won't make it to index i+1
        - Therefore, reset startIndex = i + 1: moving on to next possible starting point.
        - 'total':simply indicates if we can make it a circle
        - 1 base case, if they're null or 0 length
        */
        if(gas.length == 0 || cost.length == 0 || gas == null || cost == null)
            return -1;
        

        int total = 0; 
        int remaining = 0;
        int startIndex = 0;

        for(int i =0; i < gas.length; i++){
            total+= gas[i] - cost[i];
            remaining+= gas[i] - cost[i];
            if(remaining < 0){//we cant make it to the next place so we need to reset start index to next value and reset remainng gas.
                startIndex = i + 1;
                remaining = 0;
            }
        }

        return total < 0 ? -1 : startIndex ;

        
    }
}