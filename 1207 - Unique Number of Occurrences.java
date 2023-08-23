class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        /*Algorithm:
        - populate hashmap for # -> occurrence
        - then populate hashset to see num duplicates.
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> uniqueOccurrences = new HashSet<>();
        for(int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Integer key : map.keySet()){
            if(uniqueOccurrences.contains(map.get(key)))
                return false;
            uniqueOccurrences.add(map.get(key));
        }
        return true;
    }
}