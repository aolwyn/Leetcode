class Solution {
    public String addBinary(String a, String b) {
        /*Algorithm:
        - we are counting binary values of strings, so we can use a decrementing for loop.
        - we will use string builder to build the new binary string; just note, need to reverse after because workig backwards.
        - use a carry variable initialized in for loop, add to it from a and b if their lengths have not been exhausted. 
        - use ascii subtraction to see if valid entries are 1/0's
        */
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length() -1;

        for(int carry = 0;i>=0 || j>= 0 || carry > 0; --j, --i ){
            carry+= (i >=0 ? a.charAt(i)-'0' : 0) + (j >= 0 ? b.charAt(j)-'0' : 0);
            sb.append(carry % 2);
            carry/=2;
        }
        return sb.reverse().toString();
    }
}