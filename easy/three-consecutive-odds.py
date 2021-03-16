class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        past1 = 0 
        past2 = 0
        
        for e in arr:
            if past1 %2 !=0 and past2 %2 !=0 and e %2 !=0:
                return True
            past2 = past1
            past1 = e
            
        return False
