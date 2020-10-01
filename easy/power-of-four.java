class Solution {
    public boolean isPowerOfFour(int num) {
        if (num ==1) return true;
        if (num <=2) return false;
        String s = Integer.toBinaryString(num);
        if (s.length() % 2 ==0 ) return false;
        for (int i=1; i<s.length(); i++){
            if (s.charAt(i) != '0') return false;
        }
        return true;
    }
}
