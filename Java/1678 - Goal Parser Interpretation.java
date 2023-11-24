class Solution {
    public String interpret(String command) {
        /*Algorithm:
        - cheeky method and use string replacement to get the correct interpretation.
        - 1 base case, a null or empty string
        */

        if(command.length() == 0 || command == null) 
            return command;
            
        String inter = command.replace("()", "o");
        inter = inter.replace("(al)", "al");
        return inter;
    }     
}
