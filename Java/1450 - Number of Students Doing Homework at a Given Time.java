class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        /*Algorithm:
        - run for loop for each element, check if queryTime is within end time and start time inclusive
        */
        int count = 0;

        for(int i =0; i < startTime.length; i++){
            if( startTime[i] <= queryTime && queryTime <= endTime[i])
                count++;
        }
        return count;
    }
}