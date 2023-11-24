class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*Algorithm:
        - we are looking for a duplicate so hashmap or hashset.
        - populate chosen method, if it contains more than 1, return 
        - 1 base case, only 1 value
        */
        if(nums.length <= 1)
            return false;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}