class Solution {
    public void moveZeroes(int[] nums) {     
        //two pointer it.
        //right pointer explores non-zero element 
        //left pointer finds a zero element
        if(nums.length < 2) return;
        
        int length = nums.length;
        int left = 0;
        int right = 0;
        
        while(right < length){
            //if left is not on a zero, increment both
            if(nums[left] !=0){
                left++;
                right++;
                
                //if right pointer finds a zero, increment it and find next non-zero value. 
            }else if(nums[right] == 0){
                right++;
                //perform the swap between the 2 (the 0 and then the next non-zero value)
            }else{
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;  
            }
        }
    }
   
}