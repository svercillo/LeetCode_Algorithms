class Solution {
    
    private void print(Object line) {
        System.out.println(line);
    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums){
            if (map.get(i) == null){
                map.put(i,1);
            } else {
                map.put(i, map.get(i) +1);
            }
        }
        
        
        List<Integer> inds = new ArrayList<>();
        
        for (int e : map.keySet()){
            inds.add(e);
        }
        
        
        List<List<Integer>> list = new ArrayList<>();
        for (int i =0; i< (1 << map.size()); i ++){    
            
            
            List<List<Integer>> temp = new ArrayList<>();
            // List<Integer> l = new ArrayList<>();
            temp.add(new ArrayList<>());

            for (int j =0; j<map.size(); j++){
                if ((i & (1 <<j)) > 0){
                    if (map.get(inds.get(j)) == 1){
                        for (int w =0; w<temp.size(); w++){
                            temp.get(w).add(inds.get(j));
                        }
                    } else {
                        int curr_size = temp.size();
                        for (int w =0; w<curr_size; w++){
                            for (int y =1; y < map.get(inds.get(j)); y++){
                                List<Integer> l_new = new ArrayList<>(temp.get(w));
                                for (int u =0; u < y+1; u++)
                                    l_new.add(inds.get(j));
                                temp.add(l_new);
                            }
                            temp.get(w).add(inds.get(j)); // for case where y ==1 
                        }
                    }
                }
            }
            list.addAll(temp);
        }
        
        
        
        return list;
    }
}
