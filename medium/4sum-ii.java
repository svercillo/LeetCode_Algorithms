class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i =0; i< N; i++){
            for (int j =0; j<N; j++){
                int sum1 = A[i] + B[j];
                int sum2 = C[i] + D[j];
                
                if (map1.get(sum1) == null){
                    map1.put(sum1, 1);
                } else {
                    map1.put(sum1, map1.get(sum1)+ 1);
                }
                if (map2.get(sum2) == null){
                    map2.put(sum2, 1);
                } else {
                    map2.put(sum2, map2.get(sum2)+ 1);
                }                
            }
        }
        int c = 0; 
        for (int n : map1.keySet()){
            if (map2.get(-n) != null){
                c += map2.get(-n) * map1.get(n);
            }
        }
        return c;
    }
}
