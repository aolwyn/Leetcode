class Solution {
    /*Algorithm:
        - we have a few mappings. We can use a hashmap to map character (phone # digit) --> letters
        - we want all combinations, so this is a permutation / backtrack problem.
        - we start with the first digit. for each character in the mapped string, we will append to the temp.
            --> our end casing is if the length of letters = length of input or if the index goes out of bounds.
        - 1 base case, if the digits is blank string 
    */

    private Map<Character, String> digitToChar = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) 
            return new ArrayList();
        
        List<String> combinations = new ArrayList();
        backtrack(digits, combinations, "", 0);
        return combinations;
    }

    public void backtrack(String digits, List<String> combinations, String cur,int index) {
        if (cur.length() == digits.length()) {
            combinations.add(cur);
            return;
        } else if (index >= digits.length()) {
            return;
        } else {
            String digit = digitToChar.get(digits.charAt(index));
            for (char c : digit.toCharArray()) {
                backtrack(digits, combinations, cur + c, index + 1);
            }
        }
    }
}
