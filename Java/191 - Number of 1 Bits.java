public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /*Algorithm:
        - we will use bit shifting. 
        - we right shift, 11101 --> 1110 --> 111 -->11 -->1 for example. we can run a for loop
        - in for loop, shift value by i positions and bitwise and with 1, check if == 1.
        */
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            n >>= 1; //this shifts it right by 1 position
        }
        return count;

    }
}