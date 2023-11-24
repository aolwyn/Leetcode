class Solution {
    public int myAtoi(String s) {
        /*Algorithm:
        - step 1: get rid of mf whitespace (while ' ' continue)
        - step 2: deal with + / - (check char)
        - step 3: deal with number (curr* by 10) + number - 0
        - step 3.5: overflow (check bounds) <-- constantly check in step 3's loop as you updated the values.
        - 1 base case, if empty string
        */

        if(s.length() == 0 || s == null) {
                return 0;
            }
        // helper variables
		int res = 0, i = 0, sign = 1;
		
		// get rid of whitespace
		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		
		// check for sign
		if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			// change if negative, iterate
			if (s.charAt(i++) == '-') {
				sign = -1;
			}
		}
		
		// now iterate across digits if any
		// should only be in range 0-9
		while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			// check if we will go over the max
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
				if (sign == -1) {
					return Integer.MIN_VALUE;
				}
				return Integer.MAX_VALUE;
			}
			
			// update res
			res = res * 10 + (s.charAt(i++) - '0');
		}
		return sign * res;
    }
}