class Solution {
    public int strStr(String haystack, String needle) {
        //we can use the built in indexOf feature; if it exists, it'll return something
        //greater than -1. otherwise, we know it doesn't exist
        if(haystack.indexOf(needle)>-1){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}