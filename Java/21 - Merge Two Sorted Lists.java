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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode returned = new ListNode();
            ListNode head = returned;
            
            while(list1!= null && list2 != null){
                if(list1.val > list2.val){
                    returned.next = list2;
                    list2 = list2.next;
                }else{
                    returned.next = list1;
                    list1 = list1.next;
                }
                returned = returned.next;
            }
            
            if(list1 == null) returned.next = list2;
            if(list2 == null) returned.next = list1;
     return head.next;   
    }
}