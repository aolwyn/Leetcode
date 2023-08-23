class Solution {
    public String restoreString(String s, int[] indices) {
        //can also be done using an array
        StringBuilder res = new StringBuilder(s);
        int l = s.length();
        for (int i = 0; i < l; i++) {
            res.setCharAt(indices[i], s.charAt(i));
        }
        return res.toString();
    }
}