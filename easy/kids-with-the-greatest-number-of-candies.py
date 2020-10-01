class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        res = []
        greatest = -1
        for c in candies:
            if c > greatest:
                greatest = c
                
        for c in candies:
            if c + extraCandies >= greatest:
                res.append(True)
            else:
                res.append(False)
        return res
            
