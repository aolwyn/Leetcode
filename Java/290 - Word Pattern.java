class Solution {
    public boolean wordPattern(String pattern, String s) {
        /*Algorithm:
        - we are mapping letters to words (pattern --> word) so we use a map; but we need 2.
        - we need to be able to map both ways.
        - possible to have more chars than words or vice versa, so split.
        - in each iteration, we need to check both ways of mapping; the char to word and the word to character. if any of them dont match up, then we know its not valid.
     
        */
        String[] sArray = s.split(" ");
        if(pattern.length() != sArray.length) return false;

        HashMap<Character,String> charToWord = new HashMap<>();
        HashMap<String,Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
        
            if(charToWord.containsKey(pattern.charAt(i)) && !charToWord.get(pattern.charAt(i)).equals(sArray[i])) {
                return false;
            }
            
            if(wordToChar.containsKey(sArray[i]) && !wordToChar.get(sArray[i]).equals(pattern.charAt(i))) {
                return false;
            }
            
            charToWord.put(pattern.charAt(i),sArray[i]);
            wordToChar.put(sArray[i],pattern.charAt(i));
        }
        return true;   
    }
}