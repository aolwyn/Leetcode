class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*Algorithm + Thoughts:
        - we are given a list of strings and want to find those that are anagrams.
        - anagram is word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
        - for solution, we will use a hashmap; map a string --> list.
        - the string will represent the 'sorted' current string and be used as the key.
        - if ordered string not in the map, then we add it and empty arraylist.
        - no matter what add value after.
        */

        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());

       
    }
}