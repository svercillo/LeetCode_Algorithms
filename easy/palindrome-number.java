class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || x % 10 == 0 && x != 0 )
            return false;
        
        int revertedNum= 0;
        while (x> revertedNum){
            revertedNum = revertedNum *10 + x % 10;
            x = x /10; 
        }
        
        if (x == revertedNum || x == revertedNum / 10)
            return true;
        return false;
        
//         return x == revertedNum || x == revertedNum/10; 
        
    
    
    }
}
