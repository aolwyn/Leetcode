class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*Algorithm:
        - we will use a sliding window with a hash map --> value : last occurrence.
        if the values exist within k range, we return true. otherwise, false.
        */
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
            
            else if(Math.abs(map.get(nums[i]) - i) <= k)
                return true;
            
            else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}