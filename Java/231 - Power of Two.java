class Solution {
    public boolean isPowerOfTwo(int n) {
        /*Algorithm:
        - to check using a loop if something is a power of two, we can divide it by 2 while it is greater than 1.
        - if at any point you get a non 2 divisor or some remainder and curr val isnt 1, then return false.
        - 2 base cases, NEED TO BE CHECKED IN ORDER:
        1. if n == 1, anything ^ 0 = 1.
        2. if first number is less than 0 or if it isnt divisible by 2, we can say it's not valid
        */
        if(n == 1)
            return true;

        if( n % 2 != 0 || n < 0 || n == 0)
            return false;

        int temp = n;
    
        while(temp > 1){
            if(temp % 2 != 0)
                return false;
            
            temp = temp / 2;
            
        }



        return true;
    }
}