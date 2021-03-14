import json

class Node:
    arr = []
    _sum = 0
    index = 0
    _map ={}

    def __init__(self, node=None, index=None):
        
        if node is not None:

            self.arr = node.arr.copy()
            self._map = node._map.copy()
            self._sum += node._sum

        
    def add(self, i, ind):
        self.arr.append(i)
        self._sum += i
        self.index = ind
        self._map[i] -= 1
        
    
class Solution:
    def combinationSum2(self, candidates, target):
        candidates.sort()
        res = []
        _map = {}

        for c in candidates:
            _map[c] = _map[c] + 1 if c in _map else 1
        
        node = Node()
        node._map = _map
        self.dfs(node, candidates, res, target)


        return res
        
    def dfs(self, curr, cand, res, target):
        
        if curr._sum == target:
            res.append(curr.arr)
        elif curr._sum > target:
            return 

        _next = set({})        
        for i in range(curr.index, len(cand)):
            if curr._map[cand[i]] >0 and cand[i] not in _next:
                _next.add(cand[i])
                new = Node(node=curr)
                new.add(cand[i], i)
                self.dfs(new, cand, res, target)

        
