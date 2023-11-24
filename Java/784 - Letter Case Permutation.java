class Solution {
    /*Algorithm:
    - we will use a backtrack method.
    - we start with empty string, if not digit, continue.
    - if it is a digit, then we can go down each respective path using an upper + lowercase version of letter.
    - end the search when the current index is at the length of string
    */
    private List<String> permutations = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        backtrack("",s,0);
        return permutations;
    }

    void backtrack(String currString, String s, int index){
        if(index >= s.length()){
            permutations.add(currString);
            return;
        }
        if(Character.isLetter(s.charAt(index))){
            char c = s.charAt(index);
            backtrack(currString+Character.toUpperCase(c), s, index+1);
            backtrack(currString+Character.toLowerCase(c), s, index+1);

        }else{
            backtrack(currString+s.charAt(index), s, index+1);
        }
    }
}