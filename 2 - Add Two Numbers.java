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
        /*Algorithm:
        - we use addition with a carry.
        - we want to keep adding while there's a node left in either of the two lists.
        - add mod 10 value to new node then move to next nodes.
        - one major consideration, if there's anything leftover after both lists have been traversed, add 1 more node.
        - Note: we need to make a new linked list to be returned.
        */

        ListNode returned = new ListNode(0);
        ListNode head = returned;
        int sum = 0;
        
        while(l1 != null || l2 != null){
            sum /= 10; // we just want to see if there's a carry over here. (think 9+9 = 18, new node gets 18 % 10 (8) so 10/10 = 1 so starting sum has 1 in next position)
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode temp = new ListNode(sum % 10);
            returned.next = temp;
            returned = returned.next;
        }
        if(sum / 10 == 1)
        {
            returned.next = new ListNode(1);
        }
        return head.next;  
    }
}