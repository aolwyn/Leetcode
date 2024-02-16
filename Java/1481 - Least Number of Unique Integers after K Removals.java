class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        /*Algorithm:
        - can use a frequency map and sorting.
        - first populate frequency map.
        - sort values in frequency map in asc order and record them in the array nums
        - iterate through nums, for curr value we subtract k by nums[i]. if we go below 0, we have removed k elements, andthe min number of different integers in the array
        is the length of nums minus the index i that we traverse to at the current time
        */
        if(arr.length == 0 || arr.length < k)
            return 0;

            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i =0; i < arr.length; i++){
                map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            }

            List<Integer> nums = new ArrayList<>(map.values());
            Collections.sort(nums);

            for(int i = 0; i < nums.size(); i++){
                k-= nums.get(i);
                if(k < 0){
                    return nums.size() - i;
                }
            }
        return 0;       
    }
}