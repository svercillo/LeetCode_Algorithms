class MyQueue {
    
    public Stack<Integer> pushstack = new Stack<>();
    public Stack<Integer> popstack = new Stack<>();
    public boolean empty =false;

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (this.popstack.size() != 0){
            this.pushstack.push(this.popstack.pop());
        }
        this.pushstack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (this.pushstack.size() != 0){
            this.popstack.push(this.pushstack.pop());
        }
        return this.popstack.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        while (this.pushstack.size() != 0){
            this.popstack.push(this.pushstack.pop());
        }
        return this.popstack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (this.pushstack.size() + this.popstack.size() != 0) return false;
        return true;
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
