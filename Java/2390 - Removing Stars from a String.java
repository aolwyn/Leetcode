class Solution {
    public String removeStars(String s) {
        /*Algorithm:
        - 2  approaches; do it using a stack, or, with a new string/stringbuilder.
        -pop when value is * / remove value at length -1, otherwise append
        - USE REMOVECHARAT ! 
        */
        StringBuilder removed = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '*'){
                removed.append(s.charAt(i));
            }else{
                removed.deleteCharAt(removed.length()-1);
            }
        }
        return removed.toString();
    }
}