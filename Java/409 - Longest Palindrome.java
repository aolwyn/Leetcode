class Solution {
    public int longestPalindrome(String s) {
        /*Algorithm:
        - longest palindrome will be created with # of letters we have at least 2 of plus 1.
        - populate a hashmap to get number of occurrences.
        - iterate through each value in the map. we take value divide by 2 to get number of valid entries (letters with 2+)
        - multiply count of multiple of 2's by 2 to get actual length of palindrome
        - return min of original string and new count + 1
        */

        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(Integer c : map.values()){
            count+= c /2;
        }
        count*=2;
        return Math.min(s.length(),count+1);
    }
}