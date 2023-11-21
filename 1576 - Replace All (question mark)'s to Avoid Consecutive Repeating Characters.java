class Solution {
    public String modifyString(String s) {
        /*Algorithm:
        - we need to replace all '?' with a letter than is not the same as any touching character.
        - 2 major cases to consider, if the ? appears at the end or beginning of string.
        - the easiest solution is to recognize that we only need to consider replacement for 3 characters
            -> we only need to consider 3 because no matter what, in a window size of 3 and you're comparing against 2 others,
            the remaining character will replace the ?

        - general algorithm is to search for ? linearly, when found, see where it is located then find 1/3 chars to replace with.
        */
        if(s.length() == 0 || s == null)
            return "";
            
        char[] cs= s.toCharArray();
        int n = cs.length;

        for(int i =0; i < n; i++){
            if(cs[i] == '?'){ // found a ?
                for (char c = 'a'; c <= 'c'; ++c) { //heres where we check which of the 3 chars to replace.
                    if ((i > 0 && cs[i - 1] == c) || (i + 1 < n && cs[i + 1] == c)) { //bound / location check
                        continue;
                    }
                    cs[i] = c; //update value
                    break;
                }
            }
        }
        return String.valueOf(cs);
    }
}