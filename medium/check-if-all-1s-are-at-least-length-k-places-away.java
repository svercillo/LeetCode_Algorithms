class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        TreeMap<Integer, Boolean> map = new TreeMap<>(Collections.reverseOrder()); 
        for (int i =0; i<nums.length; i++){
            if (nums[i] == 1){
                map.put(i, true);
            }
        }
        if (map.keySet().size() <=1 ) return true;
        List <Integer> l = new ArrayList<>();
        for (int n : map.keySet()){
            l.add(n);
        }
        
        // System.out.println(l);
        
        for (int i=0; i<l.size()-1; i++){
            // System.out.println(l.get(i));  
            // System.out.println("888");  
            // System.out.println(l.get(i+1));  
            if (l.get(i) - l.get(i+1) <= k){
                
                return false;  
            } 
                
        }
        return true;
    }
}
