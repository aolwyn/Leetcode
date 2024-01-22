class Solution {
    public int characterReplacement(String s, int k) {
        /*Algorithm:
        - we have a string S and number of replacements k.
        - we want to make the largest contiguous subarray of same char with k replacements (max)
        - we can use a sliding window with hashmap approach.
        - we will use a left and right pointer to hold bounds and array to hold frequencies(26 possible chars)
        - the right pointer checks the next element. take the highest frequency so far.
        - after updating max frequency in current window, check if the max with replacements is greater than the number of replacements within the window size.
        - if it is, update the window size by decremetign element at left boundary then increasing boundary
        - otherwise we update overall max


        */
       int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
