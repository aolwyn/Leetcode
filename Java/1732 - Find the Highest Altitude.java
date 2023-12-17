class Solution {
    public int largestAltitude(int[] gain) {
        /*Algorithm:
        - work through the array, update a curr against max. start at 0, take highest
        */
        int highest = 0;
        int curr = 0;

        for(int height : gain){
            curr+= height;
            highest = Math.max(curr,highest);
        }
        return highest;
    }
}