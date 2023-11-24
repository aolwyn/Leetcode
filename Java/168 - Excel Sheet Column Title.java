class Solution {
    public String convertToTitle(int columnNumber) {
        /*we recognize that the algorithm uses modular division.
        we can update the string accordingly using ASCII subtraction.
        */
        int n = columnNumber;
        StringBuilder sb = new StringBuilder();
        while(n >0 ){
            sb.append((char)('A' + (--n)%26));
            n = n/26;
        }
        return sb.reverse().toString();
    }
}