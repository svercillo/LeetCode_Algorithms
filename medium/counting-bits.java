class Solution {
    public int[] countBits(int num) {
        int [] array = new int[num+1];
        for (int n =0; n<=num; n++){
            int i =1;
            int ones = 0;
            while (i <=n){
                if ((n & i) > 0) {
                    ones++; 
                }
                i = i<<1;
            }
            array[n] = ones;
        }
        return array;
    }
}
