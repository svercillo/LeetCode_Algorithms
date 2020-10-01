class CustomStack {
    
    public int [] array;
    public int index =-1;
    public CustomStack(int maxSize) {
        array = new int[maxSize];
    }
    
    public void push(int x) {
        try{
            index ++;
            array[index] = x;   
        } catch(Exception ex){
            index--;
            return;
        }
    }
     
    public int pop() {
        try{
            index --;
            return array[index+1];
        } catch (Exception ex) {
            index ++; 
            return -1;
        }
    }
    
    public void increment(int k, int val) {
        if(index +1 < k){
           k = index+ 1; 
        }
        for (int i =0; i<k; i++){
           array[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
