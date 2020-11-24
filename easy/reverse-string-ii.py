def remaining(s1: str, s2: str)->str:
    return len(s2) -len(s1); 

class Solution:
      
    def reverseStr(self, s: str, k: int) -> str:
        string = ""
        if k ==1:
            return s        
        i =0
        while i < len(s):
            if remaining(string, s) < k:
                string += (s[i:])[::-1]
                i = len(s) # end 
            elif remaining(string, s) >= k and remaining(string,s) < 2*k:

                string += (s[i:i+k])[::-1] + s[i+k:]
                i = len(s)  # end 
            else:
                string += (s[i:k+i])[::-1]
                string += s[i+k:i+2*k]
                i += 2 *k
        return string
