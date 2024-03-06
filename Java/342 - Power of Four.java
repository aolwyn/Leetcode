class Solution {
    public boolean isPowerOfFour(int n) {
        /*Algorithm:
        - check modular division ,if remainder isn't 0, then we can just return false.
        - if divisible, check value / 4
        - continue until less than 1
        */

        if(n == 1)
            return true;

        if(n < 0 || n == 0 || n % 4 != 0)
            return false;

        int temp = n;

        while( temp > 1){
            if(temp % 4 != 0)
                return false;
            
            temp /= 4;
        }
        return true;
    }
}