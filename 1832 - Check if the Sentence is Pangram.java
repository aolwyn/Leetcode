class Solution {
    public boolean checkIfPangram(String sentence) {
        //base case, 26 letters in alphabet; therefore, must be at least 26 long.
        if(sentence.length() < 26) return false;
        /*algorithm:
        - using a for loop, take character and get ascii value representative and
        - add to value in array.
        - we can use an array as a map of size 26. 
        - after, use for loop to see if any are 0. 

        alternatively, use a hashmap and getordefault while looping through keys.
        */

        int[] letters = new int[26];

        for(int i =0; i<sentence.length(); i++){
            char letter = sentence.charAt(i);
            int index = letter - 'a';
            letters[index]++;
        }
        for(int i = 0; i < letters.length; i++){
            if(letters[i] <= 0)
            return false;
        }
        return true;
    }
}