class Solution {
    public boolean isPowerOfThree(int n) {
        /*Algorithm:
        - check modular division ,if remainder isn't 0, then we can just return false.
        - if divisible, check value / 3
        - continue until less than 1
        */
        if(n == 1)
            return true;

        if(n < 0 || n == 0 || n % 3 != 0)
            return false;
        
        int temp = n;

        while( temp > 1){
            if(temp % 3 != 0)
                return false;
            
            temp = temp / 3;
        }
        return true;
    }
}