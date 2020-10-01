/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode * l = nullptr;
        while(head != nullptr){
            
            if(l ==nullptr){
                l = new ListNode(head->val, nullptr);
            } else {
                ListNode * prev = new ListNode(head->val, head);
                prev->next = l; 
                l = prev;
            }
            head= head->next;    

        }
        return l;
    }
};
