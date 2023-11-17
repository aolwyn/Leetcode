class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*Thoughts:
        - we have an array of size m + n in the form of nums1 and the sizes m and n. 
        - any value = 0 we ignore?
        - 2 pointer approach with a helper to find next non-zero element?
        - we can work backwards.

        Algorithm:
        - the idea is to use a 2 pointer solution; 1 pointer points to the max value in each array.
        - we keep track of total size of array (m + n -1) indices.
        - with each of these, we compare if the size of the first array is > 0 (for elements looked at) and the value.
        - assign from end of array --> beginning like so.
        */
        //3 cases: if 1 is bigger, if 2 is bigger, 3 if one array has been exhausted


        // Three pointer technique
        int r1 = m-1;
        int r2 = n-1;

        for(int w = m+n-1; w >= 0; w--) {
            if(r1 >= 0 && r2 >= 0) {
                nums1[w] = nums1[r1] > nums2[r2] ? nums1[r1--] : nums2[r2--];
            } else if (r1 >= 0) {
                nums1[w] = nums1[r1--];
            } else {
                nums1[w] = nums2[r2--];
            }
        }
    }
}