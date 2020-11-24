class Solution {
    
    void print(Object line) {
        System.out.println(line);
    }
    public boolean isSubsequence(String s, String t) {
        Map<String, Integer> freq = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i =0; i< t.length(); i++){
            String k = "" +t.charAt(i);
            
            if (map.get(k)== null){
                map.put(k,i);
                freq.put(k, 1);
                continue;
            }

            
            map.put(k + Integer.toString(freq.get(k)), i);
            freq.put(k, freq.get(k) +1);
            
        }
        freq.clear();
        Set<String> set = new HashSet<>();
        int prev =-1;
        for (int i =0; i<s.length(); i++){
            String k = "" +s.charAt(i);

            if (!set.contains(k)){
                set.add(k);
                if (map.get(k)==null){
                    
                    return false;
                } else {
                    if (prev >= map.get(k)){
                        return false;
                    } else {
                        prev = map.get(k);
                    }
                }
                freq.put(k, 1);
            } else {
                String key = k + Integer.toString(freq.get(k)); 
                if(map.get(key)==null){
                    return false;
                } else {

                    prev = map.get(key);
                    freq.put(k, freq.get(k) +1);
                }
            }
        }
        

        
        return true;
    }
}
