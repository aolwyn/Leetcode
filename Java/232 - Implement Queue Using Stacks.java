class MyQueue {
    /*Algorithm:
    - Stacks are LIFO. this means, to reverse it, we need to use 2 stacks to keep get the 'correct' order. we can use a custom move function to pop off the first stack to get in the 
    queue order.
    */
    
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> out = new Stack<>();
    public MyQueue() {
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        move();
        return out.pop();

    }
    
    public int peek() {
        move();
        return out.peek();
        
    }
    
    public boolean empty() {
        return stack1.isEmpty() && out.isEmpty();
    }

    public void move(){
        while (out.isEmpty()) {
            while (!stack1.isEmpty()) {
                out.push(stack1.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */