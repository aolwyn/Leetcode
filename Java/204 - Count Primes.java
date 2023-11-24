class Solution {
    public int countPrimes(int n) {
        /*Algorithm:
        - A prime number is defined as number divisible only by 0, 1, and itself.
        - we can use an array to keep track of numbers and their multiples.
        - 1 major base case, if n = 0 or 1.
        - use the fact that boolean array defaults to false.
        */
        if(n <= 1) return 0;

        boolean[] numbers = new boolean[n];
        int count = 0;

        for(int i = 2; i < numbers.length; i++){
            if(!numbers[i])
            count++;
            for(int j = 2; j*i < n; j++){
                numbers[j*i] = true;
            }
        }
        return count;
    }
}