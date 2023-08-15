class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        //base case: 0/1 length of words
        if(words.length == 1 || words.length == 0) return words.length;
        /*Algorithm:
        - we use a hash map to first translate the message.
        - we then use a hash set to see if transform is present.
        - if not present, we add 
        */
        int count = 0; // <-- could also just use size of the map.
        HashSet<String> map = new HashSet<>();
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
				".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
				".--","-..-","-.--","--.."};
	      for(int i = 0; i < words.length; i++){
	        String s = ""; // <-- should make this a stringbuilder realistically
	        for(int j = 0; j < words[i].length(); j++){
	            s+= morse[(int) words[i].charAt(j)-'a']; // <-- this line casts to int and gets the mapped value
	        }
	        map.add(s);
	    }
	    return map.size();
    }
}