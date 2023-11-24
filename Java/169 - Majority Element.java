class Solution {
    public int majorityElement(int[] nums) {

        //base case: 0 or 1 length
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        int majority = nums[0];

        map.put(majority, 1);
        for(int i = 1; i  < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) > map.get(majority)) majority = nums[i];
        }
        return majority;
    }
}