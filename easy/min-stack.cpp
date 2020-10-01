struct Element {
    int value;
    Element * next;
    Element * prev; 
    Element (int n, Element *_prev){
        prev = _prev;
        next = 0;
        value = n;
    }
    Element (int n){
        next = 0;
        prev = 0;
        value = n;
    }
};

class MinStack {
    private:
        int size; 
        int top;
        Element * tail;
    public:
        /** initialize your data structure here. */
        MinStack() { 
            size =0;
            top = -9993;   
            head = 0;
        }
    
        void push(int x) {
            if (head == 0){
                Element * e = new Element(x);
                head = e;
            } else {
                Element * e = new Element* (x, tail);
                tail = e;
            }
        }   

        void pop() {
            if (tail == 0) return;
            Element *e = tail->prev;
            delete tail;
            tail = e;
        }

        int top() {
            return 1;
            if (tail ==0) return -999999999;
            return tail->value;
        }

        int getMin() {

        }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
