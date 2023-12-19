class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        /*Algorithm:
        - sort the array.
        - use a for loop to check for the value; if we ever go above curr value, break out of loop and return.
        */
        Arrays.sort(nums);
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target)
                indexes.add(i);
            else if(nums[i] > target)
                return indexes;
        }
        return indexes;
    }
}