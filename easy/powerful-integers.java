class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> power = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        
        int xn =1;
        while (xn <= bound){
            int yn = 1;
            while(yn + xn <= bound){
                if (map.get(yn + xn) == null){
                    map.put(yn+xn, true);
                    power.add(yn+xn);
                }      
                if ( y== 1) break;
                yn *= y;
            }
            if( x == 1 ) break;
            xn *= x;
            
        }              
        return power;
    }
}
