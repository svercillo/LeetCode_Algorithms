class Pair {
    int k; 
    int v;
    
    Pair(int key, int val){
        k = key;
        v = val;
    }
    
    int getKey(){
        return k; 
    }
    int getValue(){
        return v;
    }
}

int[] memoryAllocator(int[] a, int[][] queries) {
    
    HashMap<Integer, Pair> map = new HashMap<>();  // id vs starting space and size
    
    int [] res = new int[queries.length];
    int count=1; 
    for (int i =0; i< queries.length; i++){
        if (queries[i][0] == 0){
            
            int x = queries[i][1];
        
            int zeros =0; 
            int start= -1;
            boolean valid = false;

            for (int j=0; j<a.length; j++){
                if (a[j] ==0){
                    zeros ++;
                    if (zeros ==  x){
                        if (start == -1){
                            start = j;  
                        }
                        for (int w = start; w <start + x-1; w ++){
                            if(w >= a.length){
                                break; 
                            }
                            a[w] = 1;
                        }
                        valid = true;
                            
                        res[i] = start;
                        map.put(count, new Pair(start, x));
                        
                        count ++;
                        break;
                    } 

                } else {
                    zeros= 0;
                    start =-1;
                }
            }
            if (!valid) {
                res[i] = -1;
            }
        } else {
            int id = queries[i][1];
            
            if (map.get(id) == null) res[i] = -1;
            
            else{
                
                int start = map.get(id).getKey();
                int x = map.get(id).getValue();
                
                System.out.println(id);
                System.out.println(x);
                
                for (int w =start; w <start + x; w ++){
                    a[w] = 0;
                }
                
                map.remove(id);
                res[i] = x;     
            }
        }
    }
    return res;
}
