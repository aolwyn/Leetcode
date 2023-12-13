class Solution {
    public boolean isAnagram(String s, String t) {
        //base case: if the lengths are different
        if(s.length() != t.length()) return false;


        //we will use a hashmap to keep track of letter entries.
        HashMap<Character,Integer> SLetters = new HashMap<>();

        //iterate through one of them
        for(int i =0; i<s.length(); i++){
            SLetters.put(s.charAt(i), SLetters.getOrDefault(s.charAt(i),0)+1);
        }
        
        //we will now check characters in the 't' string against the letters of s. if present in the 
        //string s, we decrement then check if we went negative. if negative, return false.
        //also return false if letter is not present in the map.
        for(int i = 0; i < t.length(); i++){
            if(SLetters.containsKey(t.charAt(i))){
                SLetters.put(t.charAt(i),SLetters.get(t.charAt(i))-1);
            if(SLetters.get(t.charAt(i)) < 0) return false;
            }//close if
            else return false;
            
        }//close for
         return true;
    }
}