class Solution {
    public boolean isSubsequence(String s, String t) {
        /*Algorithm:
        - effectively 2 pointer, one for progression through string t the other for string s
        - check in order of chars in s vs chars in t, if the pointer in s isnt at length by end
        - then we know it ain't a subsequence
        - 1 base case, if length of t is less than s we can't have subsequence
        */
        if(t.length() < s.length()) return false;
        if(s.length() == 0) return true;

        int slow = 0;
        int fast = 0;
        
        while(fast < t.length()){
            if(s.charAt(slow)==t.charAt(fast)){
                slow++; 
            }
            if(slow>= s.length()){
                return true;
            }
            fast++;
        }
        return false;
    }
}