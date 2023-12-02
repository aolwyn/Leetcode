class Solution {
    public int countCharacters(String[] words, String chars) {
        /*
        - we can use an array as a map to count occurrences.
        - populate array map with chars first, each letter's position = let - 'a'
        - then solve for each string, create new map for each string to count letter occurrences in the current word, compare against chars available, use precrement to check.
        - use a boolean to check validity at end or break early as necessary.
        */
        int sum = 0;
        int letters[] = new int[26];

        for(int i =0; i < chars.length(); i++){
            ++letters[chars.charAt(i)-'a'];
        }

        for(String word : words){
            int temp[] = new int[26];
            boolean valid = true;
            for(int j = 0; j < word.length(); j++){
                char curr = word.charAt(j);
                if(++temp[curr-'a'] > letters[curr-'a']){
                    valid = false;
                    break;
                }
            }
            if(valid){
                sum+=word.length();
            }
        }
        return sum;
    }
}