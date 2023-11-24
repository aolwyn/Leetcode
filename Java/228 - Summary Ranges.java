class Solution {
    public List<String> summaryRanges(int[] nums) {
        /*Algorithm:
        - we use a 2 pointer approach.
        - left pointer checks start of the range, right pointer checks the end of the range.
        - in a for loop, we check if the current element value +1 is equal to the next element and if the right pointer will go out of bounds. 
        - if it is, we can increment the right pointer's value by 1
        - if it isn't, then we break out of the for loop. here's where we know if its a range or single number:
            --> if the right pointer is not greater than the left pointer, then we know we never looped (in the while cond.) so its a standalone value.
            --> if the right pointer IS greater than the left pointer, then we know it went into the while loop. therefore, append the range.
            
        - 1 base case, length of 0.
        */

        List<String> ranges = new ArrayList<>();
        if(nums.length == 0) return ranges;

        for(int i =0; i < nums.length; i++){
            int j = i;
            while(j +1 < nums.length && nums[j]+1 == nums[j+1]){
                j++;
            }
            if(j > i){
                ranges.add(nums[i]+"->"+nums[j]);
            }else{
                ranges.add(Integer.toString(nums[i]));
            }
            i = j;
        }   
        return ranges;

    }
}