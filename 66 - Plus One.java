class Solution {
    public int[] plusOne(int[] digits) {
        /*Algorithm:
        - digits are ordered from most significant to least significant (L-->R)
        - using this property, we can use a decrementing for loop.
        - 1 case to consider, only if its going outside the bounds of digits; in this case, create new array of size+1 and just set first value to 1 (arrays default to 0)
        */
        for(int i = digits.length-1; i>=0;i--){
            if(digits[i] <9){
                digits[i] +=1;
                return digits;
            }
            digits[i] =0;
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0] =1;
        return newDigits;
    }
}