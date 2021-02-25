# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
                
        _map = {}
        if head is None:
            return None
        while head.next is not None:
            
            if id(head) in _map:
                return _map[id(head)]
                
            _map[id(head)] = head
            head = head.next
            

            
            
