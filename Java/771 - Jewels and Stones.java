class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        /*Algorithm:
        - we can use hashmap to get all jewels then go through stones and see if each stone is a jewel.
        */
        if(jewels.length() == 0 || stones.length() == 0)
            return 0;

        HashSet<Character> map = new HashSet<>();
        
        for(int i = 0; i < jewels.length(); i++){
            map.add(jewels.charAt(i));
        }

        int count = 0;

        for(int i = 0; i < stones.length(); i++){
            if(map.contains(stones.charAt(i)))
                count++;
        }
        return count;
    }
}


//alternate solution below:


// class Solution {
//     public int numJewelsInStones(String jewels, String stones) {
//         //algorithm:
//         //check if char at i in stones is present at all in jewels.
//         if(jewels.length() == 0) return 0;
//         int count = 0;
//         for(int i = 0; i < stones.length(); i++){
//             if(jewels.contains(String.valueOf(stones.charAt(i)))) count++;
//         }
//         return count;
//     }
// }