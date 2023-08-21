class Solution {
    public String mergeAlternately(String word1, String word2) {
        /*Algorithm:
        - we can look at the length of the 2 strings, figure out which is greater. 
        - or, use a conditional for loop.
        - use string builder for efficiency.
        */
        int m = word1.length();
        int n = word2.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m || i < n; ++i) {
            if (i < m) {
                sb.append(word1.charAt(i));
            }
            if (i < n) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}