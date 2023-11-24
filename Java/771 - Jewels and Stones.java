class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        //algorithm:
        //check if char at i in stones is present at all in jewels.
        if(jewels.length() == 0) return 0;
        int count = 0;
        for(int i = 0; i < stones.length(); i++){
            if(jewels.contains(String.valueOf(stones.charAt(i)))) count++;
        }
        return count;
    }
}