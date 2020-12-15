class Solution(object):
    def fib(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n ==0 or n == 1:
            return n
        
        
        prev1 = 1
        prev2 =0
        curr =-1 
        for i in range(2,n+1):

            curr = prev1 + prev2
            print(curr)
            prev2 = prev1
            prev1 = curr
        
        return curr
            
            
