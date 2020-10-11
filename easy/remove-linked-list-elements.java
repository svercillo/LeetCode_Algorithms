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
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(99999);
        root.next = head;
        ListNode cpy = head;
        ListNode prev = root;
    
        while (cpy !=null){
            if (cpy.val == val){
                ListNode cpy2 = cpy; 
                while(cpy2.val == val){
                    if (cpy2.next == null){
                        
                        break;
                    }
                    cpy2 = cpy2.next; 
                }
                if (cpy2.next == null){
                    if (cpy2.val != val){
                        prev.next = cpy2;
                    } else {
                        prev.next = null;        
                    }
                    
                    break;
                }
                cpy = cpy2;
                prev.next = cpy;
            }
            prev = cpy;
            cpy = cpy.next;
        }
        return root.next;
    }
}
