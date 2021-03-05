class Solution:
    
    
    def combine(self, n: int, k: int):
            
        value =[]
        self.backtrackDfs([], n, k, value)
        return value
    
    def backtrackDfs(self, arr, n, k, value):
        if len(arr) == k:
            value.append(arr)
            return 
        
        last = None
        if len(arr) ==0:
            last = 0
        else: 
            last = arr[len(arr)-1]

        for i in range(last+1,  n+1):
            arr2 = arr.copy()
            arr2.append(i)
            
            self.backtrackDfs(arr2, n, k, value)
            
            
