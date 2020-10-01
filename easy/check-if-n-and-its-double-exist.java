class Solution {
    public boolean checkIfExist(int[] arr) {
        
        Map<Integer, Boolean> map = new HashMap<>();
        
        for (int n : arr){
            if (n % 2 ==0){
                if (map.get(n/2) != null){
                    return true;
                }
            }
            if (map.get(2*n) !=  null){
                return true;
            }
            
            map.put(n, true);
        }
        return false;
    }
}
