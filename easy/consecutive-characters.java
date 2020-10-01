class Solution {
    public int maxPower(String s) {
        int max =0;
        int current =1;
        for ( int i =1; i<s.length(); i++){
            if (s.charAt(i) == s.charAt(i-1) && s.charAt(i)!= ' '){
                current ++;
                max = current > max ? current : max;
            } else {
                current = 1;
            }
        }
        return max> current ? max : current;
    }
}
