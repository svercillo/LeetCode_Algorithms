class Solution {
    public int findDuplicate(int[] nums) {
        int prod =1;    
        int ones =0;
        for (int n : nums){
            if (n==1){
                if (ones == 1) return 1;
                ones ++;
            } else if (prod % n ==0){
                return n;
            }
            prod *= n;
        }
        return -1;
    }
}
