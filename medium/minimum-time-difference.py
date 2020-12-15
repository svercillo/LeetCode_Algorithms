class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        arr  = timePoints
        arr.sort()
        print(arr)
        
        vals = []
        
        for a in arr: 
            vals.append(self.convert(a))
        
        print (vals)
        
        
        min_diff = 10000
        
        for i in range(0, len(vals)-1):
            
            if i ==0:
                m1 = 1440 + vals[0]- vals[len(vals)-1] 
                m2 = vals[1] - vals[0]
                print(m1, m2 )
                min_diff = min(m1 ,m2) if min(m1, m2) < min_diff  else min_diff
            else:
                min_diff = min(vals[i+1] - vals[i], vals[i] - vals[i-1]) if min(vals[i+1] - vals[i], vals[i] - vals[i-1]) < min_diff else min_diff 
                
        return min_diff 
    
    
    def convert(self, s):
        return  int(s[0:2])*60 + int(s[3:5])
        
