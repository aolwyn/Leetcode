class Solution {
    public int romanToInt(String s) {
        /*Algorithm:
        - we use a hashmap to populate values.
        - 2 cases: 
        --> case 1: number is bigger than next number
        --> case 2: number is smaller than following number
        - the 2 cases determine if we should add or subtract the value.
        */
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = map.get(s.charAt(s.length()-1)); //final value is just added as it has no values to check for.

        for(int i =0; i < s.length()-1; i++){
            int sign = map.get(s.charAt(i)) < map.get(s.charAt(i + 1)) ? -1 : 1;
            ans+= sign*map.get(s.charAt(i));
        }
        return ans;
    }
}