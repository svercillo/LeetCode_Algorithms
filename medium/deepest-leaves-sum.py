# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    highest = 0
    value =0
    def deepestLeavesSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.value = root.val
        self.recurrsion(root, 0)
        
        return self.value
        
   
    def recurrsion(self, node, height):
        if node == None:
            return
        
        if height > self.highest:
            self.highest = height
            self.value = node.val
        elif height == self.highest:
            self.value = self.value + node.val
        self.recurrsion(node.left, height +1)
        self.recurrsion(node.right, height+1)
        
