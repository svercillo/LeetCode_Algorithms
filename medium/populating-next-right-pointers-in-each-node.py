"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution(object):
    
    def connect(self, root):
        
        """
        :type root: Node
        :rtype: Node
        """
        if root == None or root.right == None:  
            return root
        self.root = root            
        self.recurse(root.left, 1)
        root = root.right.right 
        return self.root
        
    def recurse(self, node, height):
        if node == None:
            return
        
        # ntc === node_to_change
        ntc = node
        for i in range(1, 2**height):
            
            n = self.root
            s = '{0:32b}'.format(i)
            s = s[32-height: 32]
            
            for char in s:
                if char == "1":
                    n = n.right
                else:
                    n = n.left
            ntc.next =n
            ntc = ntc.next
        self.recurse(node.left, height +1)
            
        
