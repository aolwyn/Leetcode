class Solution {
    public int maxVowels(String s, int k) {
        /*Algorithm:
        - sliding window question
        - populate original window and count the vowels.
        - we will use custon function to check if vowel
        -after first window, iterate through and update a count
        -can use standard .charAt() to improve memory usage rather than making char array
        */
        int max = 0;
        char[] letters = s.toCharArray();
        int count = 0;
       
        for (int i = 0; i < k; ++i) {
            if(isVowel(letters[i]))
                count++;
        }
        max = Math.max(count,max);

        for(int j = k; j < letters.length; j++){
            if(isVowel(letters[j-k])){
                count--;
            }
            if(isVowel(letters[j])){
                count++;
            }
            max = Math.max(max,count);
        }
        return max;
    }

    public boolean isVowel(char c){
        return (c =='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}
