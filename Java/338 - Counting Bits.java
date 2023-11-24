class Solution {
    public int[] countBits(int n) {
        /*Algorithm:
        - There's a pattern, the current element is the ith number bitwise anded with the prev's. +1. so like ans[i] = ans[i & i-1] +1.
        - the cheeky method is to use Java's built in Integer.bitCount()
        */
        int[] numBits = new int[n+1];
        numBits[0] = 0; //line not needed technically
        for(int i =1; i <=n; i++){
            numBits[i] = numBits[i & i-1] +1;
        }
        return numBits;
    }
}