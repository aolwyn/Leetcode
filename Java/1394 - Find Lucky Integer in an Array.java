import java.util.HashMap;

class Solution {
    public int findLucky(int[] arr) {
        /*Algorithm:
        - populate a frequency map, then run through the map again and check key against value. take the max. default lucky number to -1.
        */
        HashMap<Integer,Integer> frequency = new HashMap<>();
        int lucky = -1;

        for(int num : arr){
            frequency.put(num, frequency.getOrDefault(num,0)+1);
        }

        for(Integer key : frequency.keySet()){
            if(key == frequency.get(key)){
                if(key > lucky){
                    lucky = key;
                }
            }
        }
        return lucky;
    }
}