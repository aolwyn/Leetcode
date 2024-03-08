class Solution {
    public int maxFrequencyElements(int[] nums) {
        /*Algorithm:
        - we know the #s can range from 1--> 100 so we can use a frequency map w/ an array.
        - populate the frequency map then go through it again
        - on pass through frequency map, check for max frequency. if new max freq. , update the answer
        - if equal to max count, we can just increment the elements with max frequency.
        */
        int[] cnt = new int[101];
        for (int x : nums) {
            ++cnt[x];
        }
        int ans = 0, mx = -1;
        for (int x : cnt) {
            if (mx < x) {
                mx = x;
                ans = x;
            } else if (mx == x) {
                ans += x;
            }
        }
        return ans;
    
    }
}