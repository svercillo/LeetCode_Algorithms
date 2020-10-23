class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        vals = {}
        vals['I'] = 1
        vals['V'] = 5
        vals['X'] = 10
        vals['L'] = 50
        vals['C'] = 100
        vals['D'] = 500 
        vals['M'] = 1000

        
        
        total = 0
        
        if len (s) == 1:
            return vals[s[0]]
        # elif len(s) ==2:
            
            
            
        last = False
        conti = False
        for i in range(0, len (s)-1):
            if conti:
                conti = False
                continue
            if vals[s[i+1]] > vals[s[i]]:
                if i == len(s)-2:
                    last = True
                              
                total += vals[s[i+1]] - vals[s[i]]
                print("heyy")
                conti = True
                
                
            else:
                total += vals[s[i]]
            print(total)
                
        if not last:
            total += vals[s[len(s)-1]]
        
        return total
