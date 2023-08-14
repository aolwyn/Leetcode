class Solution {
    public int numIdenticalPairs(int[] nums) {
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