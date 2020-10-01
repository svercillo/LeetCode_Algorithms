class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        int last = 1;
        int second =2;
        
        map.put(1, 1);
        map.put(2,2);
        
        for (int i=3; i<=n; i++){
            map.put(i, map.get(i-1) + map.get(i-2));
            int t = second;
            second = last;
            last = last +second;
            
        }
        return map.get(n);
    }
}
