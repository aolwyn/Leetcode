class Solution {
    public boolean isHappy(int n) {
        //we will use modular base 10 division to get the digits.
        //we will use a hash set to keep track of entries.
        //if a duplicate exists in the set or if a value cannot be added, it means a cycle exists; false.
        //otherwise, keep loopin'

        int q = n; // quotient
        int r = n; // remainder
        int s = 0; // sum
        Set<Integer> set = new HashSet<>();
        
        while( s != 1 ){
            s = 0;
            while( q > 0 ){
                r = q % 10;
                s += r*r;
                q = q / 10;
            }
            if( !set.add(s) ) return false;
            q = s;
        }
        return true;
        
    }
}