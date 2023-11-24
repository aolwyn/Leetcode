class Solution {
    public int[] sortedSquares(int[] nums) {
        /*Algorithm:
        - the array comes in ascending order. therefore, we should be using 2 pointer-style
        solution to effectively compare the abs values and populate accordingly.
        */
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0, j = n - 1, k = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[k--] = nums[i] * nums[i];
                ++i;
            } else {
                res[k--] = nums[j] * nums[j];
                --j;
            }
        }
        return res;
    }
}