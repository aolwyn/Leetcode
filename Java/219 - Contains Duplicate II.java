class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*Algorithm:
        - we are given an array. we want to find 2 indices i and j s.t. nums[i] is same as nums[j]
        - second condition is that j - i must be less than or equal to k.
        - considerations:
            - use a hash map for value --> index. 
            - if value present, check if index subtraction less than k - if not, put new index in.
        */

        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums == null)
            return false;

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){ 
                int temp = map.get(nums[i]);
                if(i - temp <= k) {
                    return true;
                }
                map.put(nums[i],i); 
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }
}