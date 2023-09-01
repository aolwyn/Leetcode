class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        /*Algorithm:
        - use regex to get rid of all punctuation, set all letters to lowercase, then split.
        - populate a hashset for all banned words.
        - use a hashmap to track word counts

        */
        Set<String> bannedWords = new HashSet<>();
        HashMap<String,Integer> wordCount = new HashMap<>();
        for (String word : banned) {
            bannedWords.add(word);
        }

        String[] validWords = paragraph.replaceAll("\\p{Punct}", " ").toLowerCase().replaceAll("\\s+", " ").split(" ");

        for(String word : validWords){
            if(!bannedWords.contains(word)){
                wordCount.put(word, wordCount.getOrDefault(word,0)+1);
            }
        }
        int max = -1;
        String mostFrequent = "";
        for(String word : wordCount.keySet()){
            if(wordCount.get(word) > max){
                max = wordCount.get(word);
                mostFrequent = word; 
            }
        }
        return mostFrequent;


    }
}