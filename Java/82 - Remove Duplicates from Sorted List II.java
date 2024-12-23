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
        - we are given a linked list.
        - 1 major condition. if there's a duplicate, we can't keep it in the list.
        - so lets do it the easy way - use a dummy head and 2 pointers.
        - when the node pointed by current is the same as current.next, iterate forward until the node value pointed by current is different than the next. 
        - if prev.next is the same as current , it means no dupe nodes between prev and current, so move prev to the position of current.
        - otherwise, means theres duplicates between prev and current so set prev.next to current.next. then move current forward.
        */
        if(head == null)
            return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.next.val == current.val) {
                current = current.next;
            }
            if (prev.next == current) {
                prev = current;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}