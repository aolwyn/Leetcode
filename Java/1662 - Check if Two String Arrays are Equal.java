class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //base cases, if one is of length 0 but the other isnt
        if(word1.length == 0 && word2.length != 0) return false;
        if(word2.length == 0 && word1.length != 0) return false;


        String w1 = "";
        String w2 = "";
        for(int i = 0; i < word1.length; i++){
            w1+=word1[i];
        }

        for(int j = 0; j < word2.length; j++){
            w2+=word2[j];
        }
        return w1.equals(w2);
    }
}