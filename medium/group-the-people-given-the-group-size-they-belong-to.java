class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>>  map = new HashMap<>();
        
        for (int i =0; i<groupSizes.length; i++){
            int n = groupSizes[i];
            
            final int lambdaI = i;
            map.computeIfPresent(n, 
                                   (key, val) -> {
                                       
                                       if (val.get(val.size()-1).size() ==n){
                                            List<Integer> l = new ArrayList<>();
                                            l.add(lambdaI);
                                            val.add(l);
                                            return val;
                                       } else {
                                           val.get(val.size() -1).add(lambdaI);
                                           return val;
                                       }
                                   }
                                   ); 
            map.computeIfAbsent(n, 
                    k -> {
                        List<Integer> l = new ArrayList<>();
                        l.add(lambdaI);
                        List<List<Integer>> list = new ArrayList<>();
                        list.add(l);
                        return list;
                    });            
        }
        List<List<Integer>> list = new ArrayList<>();
        
        for (int n : map.keySet()){
            for (List<Integer> l : map.get(n)){
                list.add(l);
            }
            
        }
        return list;
    }
}
