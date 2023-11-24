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
        /*Algorithm:
        - 2 pointer, check for value, delete if necessary.
        - save current node's next node. if current node = value, update prev's to be currs next node.
        - otherwise, it isnt equal to value, so we set the previous node's next node to be the current node.
        - after, we increment pointer.
        */
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, curr = head;
        while(curr != null) {
            ListNode nxt = curr.next;
            
            if(curr.val == val)
                prev.next = nxt;
            else
                prev = curr;
            
            curr = nxt;
        }
        return dummy.next;
    }
}