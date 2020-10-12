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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cpy = head;
        int size =0;
        while (cpy != null){
            size ++;
            cpy = cpy.next; 
        }
        
        if (size == 0) return null; 
        else if (size ==1 ) return head;
        
        k = k % size;
        if (k == 0) return head; 
        
        cpy = head;
        
        ListNode stop = null;
        
        while ( k< size){
            
            if (k == size-1){
                stop = cpy;    
            }
            cpy = cpy.next;
            k++;
        }
        ListNode start = cpy;
        
        ListNode prev =cpy;
        while (cpy!= null){
            prev = cpy;
            cpy= cpy.next;
        }
        
        prev.next = head;
        stop.next = null;
        return start;
    }
}
