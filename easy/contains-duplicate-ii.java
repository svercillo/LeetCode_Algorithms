class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>>map = new HashMap<>();
        for (int i =0; i<nums.length; i++){
            if (map.get(nums[i]) == null){
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i], l);
            } else {
                map.get(nums[i]).add(i);
            }
        }  
        System.out.println(map);
        
        for (int key : map.keySet()){
            List<Integer> l = map.get(key);
            if (l.size() >=2){
                for (int i =0; i<l.size(); i++){
                    for (int j= i+1; j<l.size(); j++){
                        if (l.get(j) -l.get(i) <= k) {
                            return true;
                        }
                    }
                }
            }
        }
        
        
        return false;
    }
}
