class Solution {
    public int kthFactor(int n, int k) {
        /*Algorithm:
        - we will use a for loop and a counter.
        - use modular division to increment, return when kth factor found
        */
        int kFactor = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                kFactor++;
            }
            if(kFactor == k){
                return i;
            }
        }
        return -1;
    }
}