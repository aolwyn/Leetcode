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
    public ListNode reverseList(ListNode head) {
        /*Algorithm:
        - we have 1 base case: if theres no head (null) or theres only 1 node.
        - to reverse a linked list, we require 3 pointers:
        1. one to point to current node
        2. one to point to previous node
        3. one to point to next node

        steps:
        1. save the next node to next to hold the next node.
        2. update the current next node to the previous value.
        3. set previous node to current node
        4. finally, update current node to the next.
        */

        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}