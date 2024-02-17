class Solution {
    public boolean areOccurrencesEqual(String s) {
        /*Algorithm:
        - we use hash map, iterate 2x, once for populate frequency once more for checking equality
        - we can use an array of size 26 because 26 possible letters.
        - if the value is 0 it means it just wasnt in source string.
        - keep track of the max occurrence to compare later.
        - O(2n) complexity, O(26) space
        */

        if(s.length() == 0 || s == null)
            return true;

        int[] letters = new int[26];

        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            letters[curr-'a'] +=1;

            if(letters[curr-'a'] > max)
                max = letters[curr-'a'];
        }

        for(int i = 0; i < 26; i++){
            if(letters[i]!=0 && letters[i] < max)
                return false;
        }

        return true;  
    }
}