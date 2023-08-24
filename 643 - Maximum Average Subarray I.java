class Solution {
    public double findMaxAverage(int[] nums, int k) {
        /*Algorithm:
        - very simple sliding window question.
        - we get our first sum value from the 0--> k elements,
        - then iteratively remove prev element from k and add next element to window.
        - no need to calculate the max running average as the highest numerator = highest avg.
        */
        int s = 0;
        for (int i = 0; i < k; ++i) {
            s += nums[i];
        }

        int ans = s;
        for (int i = k; i < nums.length; ++i) {
            s += (nums[i] - nums[i - k]);
            ans = Math.max(ans, s);
        }
        return ans * 1.0 / k;
    }
}