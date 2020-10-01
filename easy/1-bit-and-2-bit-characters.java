class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1 || bits[bits.length-2] != 1) return true;
        int i = bits.length-1;
        while (i>=0){
            if (bits[i] == 1){
                break;
            }
            i--;
        }
        int count=0;
        while (i >=0){
            if (bits[i] == 0){
                break;
            }
            i--;
            count++;
        }
        
        if (count % 2 == 0) return true;
        return false;
        
    }
}
