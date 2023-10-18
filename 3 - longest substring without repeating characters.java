class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*Algorithm:
        - we will use a hash map / hashset to keep track of entries.
        - we can use a 2 pointer approach / sliding window
        - 2 base cases: length of 0 / 1
        - if the char is duplicated, update the left bound of the sliding window to 1 + previous dupe occurence 
        */
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        int left = 0;
        int right = 0;
        int maxLength = 1;
        
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        while (right < s.length()) {
            char currChar = s.charAt(right);

            if (charIndexMap.containsKey(currChar) && charIndexMap.get(currChar) >= left) {
                left = charIndexMap.get(currChar) + 1;
            }

            charIndexMap.put(currChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}