# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        h =[]
        
        def recurse(node, arr):
            if node is None:
                return 
            
            heappush(h, node.val)
            
            recurse(node.right, arr)
            recurse(node.left, arr)
        
        recurse(root, h)
        
        ele =None
        for i in range(k):
            ele = heappop(h)
            
        return ele
