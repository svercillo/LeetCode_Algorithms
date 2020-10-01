class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
    
        for(int n : nums){
            if (map.get(n) == null){
                map.put(n, 1);
            } else {
                map.put(n, map.get(n)+1);
            }
        }            
        
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }    
        return -1;
    }   
}
