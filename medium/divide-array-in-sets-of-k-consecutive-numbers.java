class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0 || k ==0 || nums.length == 0 || k>nums.length) return false;
        else if ( k==1) return true;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();  // key: val, value: freq 
        for (int i =0; i< nums.length; i++){
            if (map.get(nums[i]) == null){
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) +1);    
            }
        }
        
        
        // for (int key : map.keySet()){
        //     System.out.print(key);
        //     System.out.println(map.get(key));
        // }
        int iter =0;
        int prev = -1;

        while(map.size() >0 ){
            if (iter % k == 0){
                prev = map.firstKey(); 
                if (map.get(map.firstKey()) == 1) {
                    map.remove(map.firstKey());
                } else {
                    map.put(map.firstKey(), map.get(map.firstKey()) -1);
                }
                // System.out.println(prev);
                // System.out.println(iter);

            } else {
                if (map.get(prev+1) == null){
                    System.out.println("SDFSDFSDFSDFS");
                    System.out.println(prev +1);
                    return false;                    
                } else if (map.get(prev+1) == 1) {
                    map.remove(prev+1);
                } else {
                    map.put(prev +1 , map.get(prev+1) -1);
                }
                prev++;
            }
            iter++;
        }
        return true;
    }
    
}
