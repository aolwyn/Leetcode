class Solution {
    public boolean isPalindrome(int x) {
        /*AlgorithmL
        - we will use integer math to obtain each digit and compare it against the original number.
        1. get the modular 10'th division to get the current digit. 
        2. multiply current reversed number by 10 and add remainder; this keeps order.
        3. update the original number's current digit by dividing by 10.
        4. compare reversed against original
        */
        int n, n1, remainder, reversed;
        reversed = 0;
        n1 = x;
        n  = x;
        while(n > 0){
            remainder = n % 10;
            reversed = reversed*10 + remainder;
            n = n/10;
        }    

        return (n1 == reversed ? true : false);

    }
}