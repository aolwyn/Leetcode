class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        /*Algorithm:
        - we can only use the letters provided in magazine to construct the ransomNote.
        - we are counting occurrences as well and absences
        - we fill a Char --> Int for letters in the magazine.
        - we compare it against the characters of the ransomnote; if it exists in map, decrement by 1.
            --> if it drops below 0 then return false or if it isnt present.
            --> if it doesn't effect above problems, then we update value in map.
        - few base cases, see constraints
        */

        if(ransomNote.length() == 0 || magazine.length() == 0 ||ransomNote.length() > 100000 || magazine.length() == 0) return false;
        Map<Character, Integer> letters = new HashMap<>();
        for(char t : magazine.toCharArray()){
            letters.put(t, letters.getOrDefault(t, 0)+1);
        }
        
        for(char c : ransomNote.toCharArray()){
            int currentLetter = letters.getOrDefault(c, 0);
            if(currentLetter ==0) return false;
            else{
                letters.put(c, letters.getOrDefault(c,0)-1);
            }
        }  
        return true;
    }
}