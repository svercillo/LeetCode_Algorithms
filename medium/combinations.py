class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        
        
        lst = list(range(1, n + 1))
        
        output = []
        def dfs (arr):
            
            if len(arr) == k:

                output.append(arr.copy())

            else:
                
                if (len(arr) ==0):
                    
                    for i in range(1, n+1):
                        arr = [i]    
                        dfs(arr)
                else:
                    
                    for i in range(n, 0, -1):
                        if len(arr) > 0 and arr[len(arr)-1] >= i:
                            # print(arr)
                            break

                        array = arr.copy()
                        array.append(i)
                        
                        dfs(array)
        
        dfs([])
        
        
        
        return output
