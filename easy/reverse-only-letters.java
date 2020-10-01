class Solution {
    public String reverseOnlyLetters(String S) {
        Stack<Character> s = new Stack<>();
        char [] carr = S.toCharArray();
        for (char c : carr){
            if ( ((int) c <= 90 && (int) c >=65) || 
                ((int) c <= 122 && (int) c >=97)){
                s.push(c);
                
            }
        }
        for (int i=0; i<carr.length; i++){
            char c = carr[i];
            if (((int) c <= 90 && (int) c >=65) || 
                ((int) c <= 122 && (int) c >=97)){
                carr[i] = s.pop();
            }
        }
        return String.valueOf(carr);
        
    }
}
