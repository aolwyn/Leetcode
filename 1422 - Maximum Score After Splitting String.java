class Solution {
    public int maxScore(String s) {
        /*Algorithm:
        - we can use 2 arrays to keep track of # 0s and # 1s to left + right of curr index respectively.
        - then we take the max of given thing of both bounds.

        - alternatively, we do this in place with 3 for loops.
            --> first for loop tracks split index,
            --> second for loop counts 0's until current split index
            --> last loop counts 1s after split index.

        */
        if(s.length() == 0 || s == null)
            return 0;
        int score = 0;

        for(int i = 1; i < s.length(); i++){
            int curr = 0;

            for(int j = 0; j < i; j++){
                if(s.charAt(j) == '0')
                    curr++;
            }

            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == '1')
                    curr++;
            }
            score = Math.max(curr, score);
        }
        
        return score;
        
    }
}