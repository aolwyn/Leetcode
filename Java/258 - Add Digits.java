class Solution {
    public int addDigits(int num) {
        /*Algorithm:
        this question basically asks to find the digital root of a number.
        The digital root of a non-negative integer can be found using modulo 9,
         and the result can be 0 or 9 only when the original number is a multiple of 9.
        */
        if(num < 10){
            return num;
        }
        else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}