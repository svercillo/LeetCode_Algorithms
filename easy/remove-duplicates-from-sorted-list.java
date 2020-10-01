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
        ListNode node = head;
        
        if (node == null){
            return node; 
        }
        
        while (node.next != null){
            ListNode n = node;
            while(n.next != null && n.val == n.next.val){
                n = n .next;
                System.out.println(n.val);
            }
            node.next = n.next;
            node = n.next;
            if (node == null) break;
        }
        return head; 
    }
}
