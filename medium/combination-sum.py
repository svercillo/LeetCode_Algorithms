        
    
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        res = []
        self.dfs(Node(), candidates, res, target)
        return res
        
    
    def dfs(self, curr, cand, res, target):
        if curr._sum == target: 
            res.append(curr.arr)
        elif curr._sum > target:
            return 
        
        
        for i in range(curr.index, len(cand)):
            new = Node(curr)
            new.add(cand[i], i)
            self.dfs(new, cand, res, target)
        
