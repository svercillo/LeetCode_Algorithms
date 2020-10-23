/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        System.out.println(node.val);
        ListNode temp = node;
        while (node.next != null){
            node.val = node.next.val;
            
            temp = node;
            node = node.next;   
        }
        temp.next = null; 
        
    }
}
