# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    _max = 0
    def maxDepth(self, root: TreeNode) -> int:
        
        self.recurse(root, 1)
        
        return self._max
    
    def recurse(self,node, num):
        if node is None:
            return
        if num > self._max:
            self._max = num
        self.recurse(node.left, num +1)
        self.recurse(node.right, num +1)
