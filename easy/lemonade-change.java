class Solution {
    public boolean lemonadeChange(int[] bills) {
        int b5 =0;
        int b10 =0;
        
        // 20, three 5s, or 1 5 and 2 10s
        
        for (int n: bills){
            if (n == 10){
                if ( b5==0 ) return false;
                b5--;
                b10++;
            } else if (n ==20) {
                if (b10 == 0){
                    if (b5 >=3) {
                        b5 -= 3;
                    } else return false;
                } else{
                    if (b5 >=1){
                        b5 --;
                        b10--;
                    } else return false;
                }
            } else{
                b5++;
            }
        }
        return true;
    }
}
