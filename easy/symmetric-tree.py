# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if (root == None or root.right == root.left and  root.left == None):
            return 1;
        
        
        
        print(root)
        print(".....")
        q = []
            
        q.append([root, 'm'])
        iter =0
        while len(q) > 0:
            iter += 1 
            print(q)
            print(len(q))
            if len(q) %2 != 0 and (len(q) != 1 or iter != 1) :
                return 0
            
            if len(q) ==2:
                print(q)
                if q[0][0].val != q[1][0].val or q[0][1] == q[1][1]:
                    return 0
            
            for i in range(0, floor(len(q)/2)):
                if q[i][0].val != q[len(q)-1 -i][0].val or q[i][1] == q[len(q)-1 -i][1] or q[i][2] != q[len(q)-1-i][2]:
                    return 0
                
                
            n = len(q)
            for i in range(n):
                node = q.pop(0)
                if node[0].right is not None:
                    print(node[0].right)
                    q.append([node[0].right, 'r', node[0].val])
                if node[0].left is not None :
                    print (node[0].left )
                    q.append([node[0].left, 'l', node[0].val])
            


        return 1
 
        
        
