class Solution {
    public int countSegments(String s) {
        int count =0;
        for (int i=0; i<s.length(); i++){
            try {
                if (i==0 && s.charAt(i) != ' ') count ++;
                else if (s.charAt(i) ==' ' && s.charAt(i+1) != ' ') count ++;    
            } catch (Exception ex){}
            
        }
        return count;
    }
}
