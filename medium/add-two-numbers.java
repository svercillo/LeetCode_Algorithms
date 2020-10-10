/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode test = l1;
        ListNode test2 = l2;
        int size1 =1;
        int size2 =1;
        while (test != null){
            size1 ++;
            test = test.next;
        }
        while (test2 != null){
            size2 ++;
            test2 = test2.next;
        }
        
        // add l2 to l1
        if (size2 > size1){
            test =l1;
            l1 = l2;
            l2 = test;
        }
        
        
        for (int i =0; i<size2; i++){
            int iter =i;
            ListNode curr2= l2;
            ListNode curr1 = l1;
            while(iter>0){
                // System.out.println(curr1.val);
                curr2 = curr2.next;
                curr1 = curr1.next;
                iter --;
            }
            if (curr1 == null || curr2 == null) break;
            System.out.println(curr2.val);
            
            curr1.val += curr2.val;
            
            
            while (curr1.val >9  && curr1.next != null ){    
                String value = Integer.toString(curr1.val);
                curr1.val = Integer.parseInt(String.valueOf(value.charAt(1)));
                curr1.next.val += 1;
                curr1 = curr1.next;
            }
            if (curr1.next == null && curr1.val > 9){
                String value = Integer.toString(curr1.val);
                curr1.val = Integer.parseInt(String.valueOf(value.charAt(1)));
                ListNode ln = new ListNode(1);
                curr1.next = ln;
            }
        }
        return l1;
    }
}
