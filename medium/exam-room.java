class ExamRoom {

    
    TreeSet<Integer> set = new TreeSet<>();
    int n;
    
    public ExamRoom(int N) {
        n = N -1;
    }
    
    public int seat() {

        if (set.isEmpty()){
            set.add(0);
            return 0;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int ele : set){
            list.add(ele);            
        }
        
        int max = 0; 
        int max_ind =0;
        if (list.size()> 0){
            if (list.get(0) > max){
                max = list.get(0);
                max_ind = 0;
            }
        }
        
        for (int i =0; i< list.size()-1; i++){
            if ((list.get(i+1) - list.get(i)) /2 > max ){
                max_ind = list.get(i) + (list.get(i+1) - list.get(i)) /2;
                max = (list.get(i+1) - list.get(i))/2;
            }
                
        }

        if ( n - list.get(list.size() -1) > max){
            max_ind = n;
        }
        
        set.add(max_ind);
        return max_ind;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}
// ["seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave","leave","seat","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","leave","seat","seat","leave","leave","seat","seat","leave"]

// [0,9,4,null,null,0,4,2,6,1,3,5,7,8,null,null,4,0,null,7,null,3,null,3,null,9,null,null,8,0,null,null,8,0,null]


/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
