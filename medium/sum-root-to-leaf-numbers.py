# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root == None: return 0
        self.sum = 0
        self.recurse(root, "")
        return self.sum
    
    def recurse (self, node, string):
        if node.right == None and node.left == None:
            string  = string  + str(node.val)
            self.sum = self.sum + int(string)
            return
        if node.left != None:
            self.recurse(node.left, string + str(node.val))
        if node.right != None:
            self.recurse(node.right, string + str(node.val))
        
    
