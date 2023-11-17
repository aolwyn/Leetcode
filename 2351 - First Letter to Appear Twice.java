import java.util.HashSet;

class Solution {
    public char repeatedCharacter(String s) {
        //we will use a hashmap to keep track of occurences.
        HashSet<Character> map = new HashSet<>();
        int i = 0;

        while (i < s.length()) {
            if (map.contains(s.charAt(i))) {
                break;
            } else {
                map.add(s.charAt(i));
            }
            i++;
        }
        return s.charAt(i);
    }
}