class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]: 
        
        vals = intervals
        vals.sort(key=lambda x: x [0])
        
        
        res = []
        start =-1
        end = -1
        for l in vals:
            if start == -1:
                start = l[0]
                end = l[1]
            if l[0] <= end:
                if l[1] > end:
                    end = l[1]
            else:
                res.append([start, end])
                start = l[0]
                end = l[1]
        if start != -1: 
            res.append([start, end])
                
        return res
