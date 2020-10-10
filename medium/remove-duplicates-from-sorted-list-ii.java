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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null; 
        
        ListNode curr = head; 
        ListNode root = null;
        ListNode res = null;
        int badPrev = -999999;
        if (curr == null){
            return null;
        }
        while(curr.next != null){
            if (curr.next.val == curr.val){ 
                badPrev = curr.val;
            } else if (badPrev != curr.val){
                if (root == null){
                    root = new ListNode(curr.val);
                    res = root;
                } else {
                    root.next = new ListNode(curr.val);
                    root = root.next;
                }
            }   
            curr = curr.next;
        }
        if (curr.val != badPrev){
            if (root == null){
                res = curr;
            } else {
                root.next = new ListNode(curr.val);    
            }
            
        }
        return res;
        
    }
}
