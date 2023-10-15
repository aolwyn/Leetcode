class Solution {
    public void reverseString(char[] s) {
            
        //to reverse the string, we will use 2 pointer.
        int left = 0;
        int right = s.length -1;
        while(left < right){
            char temp  = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}