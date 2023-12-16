class Solution {
    public boolean isPalindrome(String s) {
        /*
            2 pointer, check if valid char if not then skip.
            when both valid, check if lowercase versions are equal.
            if not equal, return false otherwise in/dec rement
        */
        if(s.length() == 0 || s.length() == 1)
            return true;

        int left = 0;
        int right = s.length()-1;
        
        while(left < right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            else{
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}