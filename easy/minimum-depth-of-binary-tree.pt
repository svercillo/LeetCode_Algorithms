# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    _min = 1000000
    def minDepth(self, root: TreeNode) -> int:
        
        if root is None:
            return 0 
        self.recurse(root, 1)
        return self._min if self._min != -1 else 1
    
    def recurse(self,root, depth):
        
        
        if root == None:
            return
        
        if root.left is None and root.right is None: 
            self._min = depth if depth < self._min else self._min
        else:
            self.recurse(root.left, depth +1)
            self.recurse(root.right, depth +1 )

        
