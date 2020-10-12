class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if (a.length() <1) return true;
        int start =0;
        int end = a.length()-1;
        boolean first = true;
        boolean sec = true;
        boolean stop = false;
        char c = 'c';
        int both =0;
        while (end > start && !stop){
            switch(c){
                case 'c':
                    if (a.charAt(start) == b.charAt(end) &&  (both ==0 || both == 1)){
                        if (b.charAt(start) != a.charAt(end)){
                            both =1;
                        }
                        break;
                    } else if (b.charAt(start) == a.charAt(end) &&  (both==0 || both == 2)){
                        both =2;
                        break;
                    }
                case 'w': //two
                    if (a.charAt(start) != a.charAt(end)){
                        if (b.charAt(start) != b.charAt(end)){
                            first = false;
                            stop = true;
                            
                        } else {
                            c = 'b';
                        }
                    } else if(b.charAt(start) != b.charAt(end)){
                        c = 'a';
                    }
                    
                    break;
                case 'a':
                    if (a.charAt(start) != a.charAt(end)){
                        first = false;
                        stop = true;
                    }
                    
                    break;
                    
                case 'b':
                    if (b.charAt(start) != b.charAt(end)){
                        first = false;
                        stop = true;
                    }
                    
                    break;
            }
            start ++;
            end --;
        }
    
      
    
        return first;
        
    }
}
