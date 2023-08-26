class Solution {
    public String gcdOfStrings(String str1, String str2) {
        /*Algorithm:
        - we understand that the smaller string is multiplied by itself x times
        - if the bigger string doesnt contain the smaller string, immediately we know
         it can return false.
        - if they are equal length, then we know to return any of them.
        -can use recursion with a substring of the bigger string of equal length to the smaller one
        */

        String bigger= str1.length() > str2.length()? str1 : str2;
        String smaller = str1.length() <= str2.length()? str1 : str2;

        if(bigger.equals(smaller))
            return smaller;

        if(!(bigger.startsWith(smaller)))
            return "";
        
        return gcdOfStrings(bigger.substring(smaller.length()),smaller);

    }
}