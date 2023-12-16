class Solution {
    public boolean backspaceCompare(String s, String t) {
        /*Algorithm:
        - use 2 stacks. if char = #, pop.
        - return the comparison of both stacks as strings
        */

        Stack<Character> slet= new Stack<>();
        Stack<Character> tlet = new Stack<>();
        
        for(int i =0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp !='#'){
                slet.push(temp);
            }else{
                if(!slet.isEmpty()){
                    slet.pop();
                }
            }
        }
        for(int i =0; i < t.length(); i++){
            char temp = t.charAt(i);
            if(temp !='#'){
                tlet.push(temp);
            }else{
                if(!tlet.isEmpty()){
                    tlet.pop();
                }
            }
        }

        return slet.toString().equals(tlet.toString());
    }
}