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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode test = l1;
        ListNode test2 = l2;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while (test != null){
            s1.push(test.val);
            test = test.next;
        }
        while (test2 != null){
            s2.push(test2.val);
            test2 = test2.next;
        }

        // add l2 to l1
        if (s1.size() < s2.size()){
            Stack<Integer> s3 = s1;
            s1 = s2;
            s2 = s3;
        }
        
        int s1_size = s1.size();

        int [] arr = new int[s1.size()+1];
        
        int i=-1;
        while(!s1.empty()){
            i++;
            int a = s1.pop();
            a += arr[i];
            if (!s2.empty()){
                a += s2.pop();
            }
            if (a >9){
                String value = Integer.toString(a);
                arr[i] = Integer.parseInt(String.valueOf(value.charAt(1)));
                arr[i+1] += 1;    
            } else {
                arr[i] =a;
            }
        }
        

        int start = arr[arr.length-1] == 0  ? arr.length-2 : arr.length-1;
        
        
        ListNode root = new ListNode(arr[start]);
        ListNode temp = root;
        for (int j = start-1; j>=0; j--){
            temp.next = new ListNode(arr[j]);
            temp = temp.next;
        }
        
        return root;
        
    }
}



// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode test = l1;
//         ListNode test2 = l2;
//         int size1 =1;
//         int size2 =1;
//         while (test != null){
//             size1 ++;
//             test = test.next;
//         }
//         while (test2 != null){
//             size2 ++;
//             test2 = test2.next;
//         }
        
//         // add l2 to l1
//         if (size2 > size1){
//             test =l1;
//             l1 = l2;
//             l2 = test;
//         }
        
        
//         for (int i =0; i<size2; i++){
//             int iter =i;
//             ListNode curr2= l2;
//             ListNode curr1 = l1;
//             while(iter>0){
//                 // System.out.println(curr1.val);
//                 curr2 = curr2.next;
//                 curr1 = curr1.next;
//                 iter --;
//             }
//             if (curr1 == null || curr2 == null) break;
//             System.out.println(curr2.val);
            
//             curr1.val += curr2.val;
            
            
//             while (curr1.val >9  && curr1.next != null ){    
//                 String value = Integer.toString(curr1.val);
//                 curr1.val = Integer.parseInt(String.valueOf(value.charAt(1)));
//                 curr1.next.val += 1;
//                 curr1 = curr1.next;
//             }
//             if (curr1.next == null && curr1.val > 9){
//                 String value = Integer.toString(curr1.val);
//                 curr1.val = Integer.parseInt(String.valueOf(value.charAt(1)));
//                 ListNode ln = new ListNode(1);
//                 curr1.next = ln;
//             }
//         }
//         return l1;
//     }
// }
