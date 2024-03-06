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
        /*Algorithm:
        - use 2 pointers, 1 to check value of current node and 1 to check value of the next node.
        - if next node is greater than the current node, it means we have a 'good' order;
        - otherwise, we know its the same, so set the next node of curr to be 2 ahead.
        */
        if(head == null)
            return head;

        ListNode curr = head;

        while(curr != null && curr.next !=null){
            if(curr.val < curr.next.val){
                curr = curr.next;
            }else{
                curr.next = curr.next.next;
            }
        }
        return head;
    }
}