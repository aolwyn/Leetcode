import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        //base cases, string is empty or null.
        if(s.length() == 0 || s == null) return false;

        //algorithm: We will use stack to determine whether or not it is valid. 
        //three cases: open bracket or closing bracket or other.

        Stack<Character> letters = new Stack<>(); //stack to keep track of opening and closing of brackets 
        
        for(int i = 0; i < s.length(); i++){
            char letter = s.charAt(i); 

            if(letter == '{'|| letter == '(' || letter == '[') 
                letters.push(letter);
            
            else if(!letters.isEmpty() && letters.peek() == '{' && letter == '}')
                letters.pop();

            else if(!letters.isEmpty() && letters.peek() == '(' && letter == ')')
                letters.pop();

            else if(!letters.isEmpty() && letters.peek() == '[' && letter == ']')
                letters.pop();

            else return false;

        } 
        return letters.isEmpty(); // in the event that there has been an extra bracket added and it wasn't caught.
    }
}