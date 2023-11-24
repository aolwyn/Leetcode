class Solution {
    public int lengthOfLastWord(String s) {
        /*Algorithm:
        - cheeky solution, split the string based on whitespace then return length of last word.
        - other solution just use two pointer tracking whitespace. or just go in reverse from last letter until whitespace.
        */
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }
}