# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        
        extra = ListNode()
        extra.next = head
        print(extra)
        temp = extra
        print(temp.next)
        i =1
        while i < m:
            temp = temp.next
            i+=1
            
        print(temp)
        start= temp
        arr = []
        while i <n+1:
            temp = temp.next
            arr.append(temp)
            i+=1 
        
        print(arr)
        
        j =  len(arr)-1
        end = arr[len(arr)-1].next
        while j > 0:
            arr[j].next = arr[j-1]
            j-=1
        
        arr[0].next = end
        
        start.next = arr[len(arr)-1]
        
        
        return extra.next
        
