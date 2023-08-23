class Solution {
    public int[] twoSum(int[] nums, int target) {
        //base case: if the length is out of bounds.
        if( nums.length < 2 || nums.length > 10000) return null;
        //algorithm:
        /*
         use a hashmap to check if the difference from the target has been found.
         if found, return target index. otherwise, add value of array to map and the index
         it is found at.
        */
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[] {i, map.get(temp)};
            }
            else{
                map.put(nums[i], i);
            }
        }
        return null;
    }
}