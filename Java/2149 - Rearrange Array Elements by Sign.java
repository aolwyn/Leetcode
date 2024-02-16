class Solution {
    public int[] rearrangeArray(int[] nums) {
        /*Algorithm:
        - we need to rearrange such that the elements of nums are in the following order:
        1. every consecutive pair of integers has opposite signs
        2. for all integers with the same sign, the order must be preserved
        3. rearranged array begins with positive integer.

        2 ways to solve this; if we don't care about extra memory, use 2 queues
        otherwise we can just use 2 pointer.
        */

        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >=0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }
        
        for(int i =0; i < nums.length; i++){
            if(i % 2 == 0){
                nums[i] = pos.poll();
            }else{
                nums[i] = neg.poll();
            }
        }
        return nums;
    }
}

/*class Solution {

    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = 1;
        for (int num : nums) {
            if (num > 0) {
                ans[i] = num;
                i += 2;
            } else {
                ans[j] = num;
                j += 2;
            }
        }
        return ans;
    }
}


*/