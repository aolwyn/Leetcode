class Solution {
    public int maxPower(String s) {
        /*Algorithm:
        - we use for loop.
        - compare curr against prev, add 1 to curr tally if valid and update running max.
        - if not same char as prev, reset curr to 1. 
        */
        if(s.length() <= 1)
            return s.length();

        int power = 1;
        int curr = 1;

        for(int i =1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                 curr++;
                power = Math.max(power,curr); 
            }else{
                curr = 1;
            }
        }
        return power;
    }
}