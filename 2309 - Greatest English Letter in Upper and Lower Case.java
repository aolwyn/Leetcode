class Solution {
    public String greatestLetter(String s) {
        /*Thoughts:
        - an english letter B is greater than letter A if B appears after A in the english alphabet. 
        - we need something to track duplicate occurrences, use a set. 
        - also need something to track 'greatness' <-- we can do this using alphanumeric value subtraction?
            --> we will iterate through from capital Z to capital A because Z has higher 'greatness'
        */

        //base case: length < 2
        if(s.length() < 2)
            return "";

        Set<Character> letters = new HashSet<>();

        //keep track of all characters.
        for(char c: s.toCharArray()){
            letters.add(c);
        }

        //calculate greatest value
        for(char let =  'Z'; let >= 'A'; let-- ){
            if(letters.contains(let) && letters.contains(Character.toLowerCase(let))){
                return Character.toString(let);
            }
        }
        return "";
    }
}