class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i =0; i<roads.length; i++){
            int [] arr = roads[i];
            map.putIfAbsent(arr[0], new HashSet<Integer>()); 
            map.putIfAbsent(arr[1], new HashSet<Integer>());
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }
        
        
        int max =0; 
        for(int key1 : map.keySet()){
            for (int key2 : map.keySet()){
                if (key1 == key2) continue;
                
                int sum =0;
                if (map.get(key1).contains(key2)){
                    sum += map.get(key1).size() + map.get(key2).size() -1;
                } else {
                    sum += map.get(key1).size() + map.get(key2).size();
                }
                max = sum > max ? sum : max;
            }
        }
        
        
        return max ;   
    }
}
