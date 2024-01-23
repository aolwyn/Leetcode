class Solution {
    public int getSum(int a, int b) {
        /*Algorithm:
        - we are asked to add 2 integers without the use of + or - operators.
        - To do this, we need to use bit manipulation.
        - Assuming the 2 intergers are of different sizes, we need to use XOR rather than 1/2 adder logic.
        - to do this, we use a carry. the carry will just take the spot of 1 of the integers and be used to line up 1's
        */

        // Iterate till there is no carry
        while(b != 0){

            // carry now contains common set bits of x and y
            int carry = a & b;

            // Sum of bits of x and y where at least one of the bits is not set
            a = a ^ b;

            // Carry is shifted by one so that adding it to x gives the required sum
            b = carry << 1;

        }
        return a;
    }
}