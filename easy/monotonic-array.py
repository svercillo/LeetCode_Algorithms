class Solution:
    def isMonotonic(self, A: List[int]) -> bool:
        if len(A) == 1:
            return True
        
        mono = True
        
        checking = False
        incr = True 
        for i in range(0, len(A)-1): 

            if checking:
                
                if incr and A[i+1] - A[i] < 0: 
                    return False
                if not incr and A[i+1] - A[i] > 0:
                    return False
                    
                    
            if A[i] != A[i+1]:
                incr = True if A[i+1] - A[i] > 0 else False
                checking = True
        return True
