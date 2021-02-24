# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        
        _set = set({})
        if head is None:
            return False
        while head.next is not None:

            
            if id(head) in _set:
                return True
                
            _set.add(id(head))
            head = head.next
            
        return False
            
            
