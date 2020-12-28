class Solution {
    public int maxDistToClosest(int[] seats) {
        int curr_count =0;
        int max =0; 
        boolean first = true;
        
        
        for (int i =0; i<seats.length; i++){
            if (seats[i] ==0 ){
                curr_count ++; 
            } else {
                
                int temp = -1;
                
                if (first){
                    temp = (curr_count);    
                } else {
                    temp = (curr_count +1 ) /2;
                }
                
                if (temp > max){
                    max = temp;
                }
                
                first = false;
                curr_count =0;
            }
        }
        
        if (curr_count > max){
            max = curr_count; 
        }
        
        return max;
    }
}
