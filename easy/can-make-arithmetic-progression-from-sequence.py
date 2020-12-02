class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        arr.sort()
        
        diff = None 
        for i in range(0, len(arr)-1):
            if diff: 
                if arr[i+1] - arr[i] != diff: 
                    return False
                    
            else:
                diff = arr[i+1] - arr[i]
        
        return True 
