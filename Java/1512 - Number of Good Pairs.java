class Solution {
    public int numIdenticalPairs(int[] nums) {
        /*Algorithm:
        - we are looking for identical number of pairs.
        - the brute force method would be to just run 2x for loop
        - other method is to use a hashmap and just count occurrences;
            -> the number of pairs that can be made for a given # of occurrences is: [n * (n-1)] / 2
        */

        if(nums.length == 0) return 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int pairs = 0;

        for(int number : nums){
            pairs += map.getOrDefault(number,0);
            map.put(number,map.getOrDefault(number,0)+1);
        }
        return pairs;
    }
}