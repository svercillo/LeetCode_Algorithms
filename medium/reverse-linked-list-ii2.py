# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        
        extra = ListNode()
        extra.next = head
    
        temp = extra
        
        i =1
        while i < m:
            temp = temp.next
            i+=1
            
        
        start= temp
        extra1 = ListNode()
        extra1.next = start.next
        start.next = extra1
        
        k = n-m
        while k  >0 :
            self.swap_and_recurse( extra1, extra1.next, k)
            k-=1 
            
        start.next = extra1.next
        
        
        return extra.next
    def swap_and_recurse(self,prev, node, iters):

        
        for i in range(0, iters):
            prev = self.swap( prev ,node)
        
        
    def swap(self, prev, node):
        prev.next = node.next
        n = prev.next.next
        node.next =n
        prev.next.next = node

        
        return prev.next
        
