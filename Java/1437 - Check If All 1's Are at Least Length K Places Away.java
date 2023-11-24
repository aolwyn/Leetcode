class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        /*Algorithm:
        - we can use a 2 pointer approach
        - when we find a 1, we start looking for next 1. if less than k, we chilling. compare to a distance int
        - otherwise, we not
        */
        if(nums.length == 0 || nums == null)
            return true;

        int distance = k + 1; // Initialize distance to a value greater than k

        for (int num : nums) {
            if (num == 1) {
                if (distance < k) {
                    return false;
                }
                distance = 0;
            } else {
                distance++;
            }
        }

        return true;
    }
}