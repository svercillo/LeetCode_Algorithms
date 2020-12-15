class Solution(object):
    def tribonacci(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n ==0 or n == 1:
            return n
        elif n ==2: 
            return 1
        
        
        prev1 = 1
        prev2 = 1
        prev3 = 0
        curr =-1 
        for i in range(3,n+1):
            curr = prev1 + prev2 + prev3
            prev3 = prev2
            prev2 = prev1
            prev1 = curr
        
        return curr
            
            
