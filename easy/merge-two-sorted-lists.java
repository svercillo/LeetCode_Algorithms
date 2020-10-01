/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            if(l2 == null) return null; 
            return l2;
        }
            
        if (l2 == null){
            if (l1 == null){
              return null; 
            }  
            return l1;    
        } 
        ListNode head = l2;
        if (l2.val > l1.val) {
            head=l1;
            l1 = l2;
            l2 = head;
        }
            
        
        while (l1 != null){
            // System.out.println(l1.val);
            ListNode prev = l2;
            boolean end = false;
            while (l1.val >= l2.val){
                if(l2.next== null){
                    end = true;
                    prev = l2;
                    break;
                } else {
                    prev = l2;
                    l2 = l2.next;
                }
            }
            ListNode temp = prev.next;
            prev.next = l1;
            ListNode l1next = l1.next;
            l1.next= temp;
            
            l2 = prev;
            l1 = l1next;
        }
        return head;
    }
}
