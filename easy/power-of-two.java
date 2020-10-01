class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n ==1) return true;
        if (n <=0) return false;
        String s = Integer.toBinaryString(n);
        // if (s.length() % 2 ==0 ) return false;
        for (int i=1; i<s.length(); i++){
            if (s.charAt(i) != '0') return false;
        }
        return true;
    }
}
