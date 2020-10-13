class Solution {
    public int maximum69Number (int num) {
        String str = "";
        String s = Integer.toString(num);
        boolean early = true;
        for (int i =0; i<s.length(); i++){
            if (s.charAt(i) =='6' && early){
                str += '9';
                early = false; 
            }else {
                str += s.charAt(i);
            }
        }
        return Integer.parseInt(str);
    }
}
