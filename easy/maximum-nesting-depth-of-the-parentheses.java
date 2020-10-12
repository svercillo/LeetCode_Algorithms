class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int depth =0; 
        for (int i =0; i<s.length();i++ ){
            if (s.charAt(i) == '('){
                depth ++;
            } else if ( s.charAt(i) == ')') {
                max = depth > max ? depth : max;
                depth --;
            }
        }
        return max;
    }
}
