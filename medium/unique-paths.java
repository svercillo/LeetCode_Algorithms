class Solution {
    public Map<Pair, Integer> map = new HashMap<>();

    public int uniquePaths(int m, int n) {
        if (m == 1 || n ==1) return 1;
        // if (m ==0 || n==0) return 0;
        
        map.put(new Pair(0,0), 1);
        
        for(int i=0 ; i<n; i++)
            map.put(new Pair(i, 0),1);

        for (int j=1; j<m; j++)
            map.put(new Pair(0,j),1);
        
        
        System.out.println(map);

        for (int i =0; i< n; i ++){
            for (int j =0; j<m; j++){
                int val= 0;
                if (map.get(new Pair(i-1, j)) != null){
                    val += map.get(new Pair(i-1, j));
                }
                if (map.get(new Pair(i, j-1 )) != null){
                    val += map.get(new Pair(i,j-1));                    
                }
                
                if (val > 0){
                    map.put(new Pair(i, j), val);
                }
            }
        }
        
        System.out.println(map);
        
        
        return map.get(new Pair(n-1, m-1));     
    }
}
