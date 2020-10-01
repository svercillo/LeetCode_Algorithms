class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        hashtable = {}
        
        alpha = "qwertyuiopasdfghjklzxcvbnm"
        for e in alpha:
            hashtable[e] = 0
        
        
        for c in magazine:
            hashtable[c] = hashtable[c] +1
        
        for c in ransomNote:
            if (hashtable[c] ==0):    
                return False
            hashtable[c] = hashtable[c] -1
        
        return True
            
            
 
            
        
