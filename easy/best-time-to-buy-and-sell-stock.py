class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) < 2: return 0
        maxdiff = 0
        prevmax = prices[0]
        prevmin = prices[0]
        for i in range(1, len(prices)):
            
            if prices[i] < prevmin: 
                prevmin = prices[i]
                prevmax = -1
            elif prices[i] > prevmax:
                prevmax = prices[i]
            
            
            if
        
        print(lst)
        return maxdiff
                
                
        # print(lst)
            
                
