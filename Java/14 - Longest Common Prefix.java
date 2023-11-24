class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*Algorithm:
        - we can take the first string. for each character in it, we will compare against other strings in the array.
        - if character doesnt matchup, return substring from 0 --> current #.
        - otherwise, continue.
        - end condition when first string length is done or if any other strings are of lesser length or previous mentioned condition
        */

        if (strs == null || strs.length == 0) return "";

        for(int i = 0; i < strs[0].length(); i++){
            char letter = strs[0].charAt(i);

            for(int j = 0; j < strs.length; j++){
                if(strs[j].charAt(i) != letter || i == strs[j].length()){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}