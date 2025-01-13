class Solution {
    public int minimumLength(String s) {
        /*Algorithm:
        - recognize that we can basically just run a frequency map. we know 26 letters (only lowercase considered)
        - the condition set is there needs to be an a value equal to the left and right of curr index. meaning need 3 values.
        - idea here is that if the frequency is even, it means we can contribute 2 to the result (leave 2 characters unpaired)
            -> abababa --> 4 a's, so new string becomes babab (we deleted closest L+R)
        - if the frequency is odd, it means we add 1 (1 character unpaired)
            -> similar to a's, but we are left with 1 rather than 2.
        - default is it never occurs.

        */
        if(s == null || s.length() == 0)
            return 0;
        int count = 0;
        int[] frequency = new int[26];

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);

            frequency[curr-'a'] += 1;
        }

        for(int j = 0; j < 26; j++){
            if(frequency[j] == 0)
                continue;
            if(frequency[j] % 2 == 0)
                count+=2;
            else
                count++;
        }
        return count;
    }
}