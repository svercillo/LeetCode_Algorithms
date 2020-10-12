class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";

         
        for (int i =0; i<s.length(); i++){
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                str += s.charAt(i);
            }
        }
        boolean pali = true;
        for (int i=0; i<(str.length())/2; i++){
            if (str.charAt(i) != str.charAt(str.length()-1-i)){ 
                pali = false;
            }
        }
        return pali;
    }
}
