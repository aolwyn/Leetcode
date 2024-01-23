class Solution {
    public int calPoints(String[] operations) {
        /*Algorithm:
        - use stack to keep track of operations.
        - if stack not empty and given C,D,+, push peek value + operation
        - otherwise we know its a number so push to stack.
        - when operations done, iterate through stack and add to sum and return
        */
        if(operations.length == 0 || operations == null)
            return 0;

        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < operations.length; i++){
            if(!stack.isEmpty() && operations[i].equals("C")){
                stack.pop();
            }else if(!stack.isEmpty() && operations[i].equals("D")){
                stack.push(stack.peek()*2);
            }else if(!stack.isEmpty() && operations[i].equals("+")){
                int temp = stack.peek();
                stack.pop();
                int num2 = stack.peek();
                stack.push(temp);
                stack.push(temp+num2);
            }else{
                stack.push(Integer.valueOf(operations[i]));
            }
        }


        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}