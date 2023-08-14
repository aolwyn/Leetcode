class Solution {
    public int[] plusOne(int[] digits) {
        //we can use a for loop to iterate through the array. we will iterate in reverse.
        
        for(int i = digits.length-1; i >= 0; i--){
            //check if the value curently is less than 9.
            if(digits[i] <9){
                digits[i]++;
                return digits;
            }
            //if it's 9, then we need to set it to 0.
            digits[i] = 0;
        }
        //if we've made it here, it means that we need an extra slot for a digit.

        int[] newDigits = new int[digits.length+1]; //default populates with 0's
        newDigits[0] = 1;
        return newDigits;

        
    }
}