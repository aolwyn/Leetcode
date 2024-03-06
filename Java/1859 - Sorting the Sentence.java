class Solution {
    public String sortSentence(String s) {
        /*Algorithm:
        - we have a string containing 9 words, separated by whitespace. 
        - the words need to be rearranged based on the # represented in the last character of the word.
        - we can split the original based on whitespace.
        - create a new string array to house the answer.
        - the word at the ith position can be determined using the final character; we can use ASCII subtraction to determine proper placement.
        - update this in the new string array.
        - when done, join the strings in the ans and return with a space.
        */
        if(s == "" || s == null || s.length() == 0)
            return "";

        String[] split = s.split(" ");
        String[] ans = new String[split.length];

        for(int i = 0; i < ans.length; i++){
            String curr = split[i];
            ans[curr.charAt(curr.length()-1) - '1'] = curr.substring(0,curr.length()-1);
        }

        return String.join(" ", ans);
    }
}