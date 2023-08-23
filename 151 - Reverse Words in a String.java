class Solution {
    public String reverseWords(String s) {
        /*Algorithm:
        - we will likely be using a 2 pointer approach.
        - few cases to consider; more than 1 space between words will fuck it up :)
        - convert to array before swap.

        1. we use .trim() to remove any trailing or leading spaces.
        2. we use regex \\s+ to remove extra spaces between words.
        3. convert to array.
        4. swap.
        5. convert back to string and return!
        */
        String temp = s.trim();
        temp = temp.replaceAll("\\s+", " ");
        String[] words = temp.split(" ");

        int left = 0;
        int right = words.length-1;

        while(left <= right){
        String swap = words[left];
        words[left] = words[right];
        words[right] = swap;
        left++;
        right--;
        }
        return String.join(" ", words);
    }
}