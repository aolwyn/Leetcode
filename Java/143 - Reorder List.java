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
    public void reorderList(ListNode head) {
        /*Algorithm:
        - we are given a linked list and want to rearrange it.
        - nodes cannot be modified.
        - L0 must map to LN, L1 to LN-1, effectively converging on one another.
        - we can use a stack to deal with this and/or a hashmap?
        - alternatively reverse the last 1/2 of the linked list then use 2 temp pointers.
        */
        
    
    ListNode fast = head;
    ListNode slow = head;
    
    //use fast + slow pointer to get to mid point
    while(fast != null && fast.next !=null){
        slow = slow.next;
        fast = fast.next.next;
    }

    //Reverse the second half of the list using a tmp variable
    ListNode second = slow.next;
    ListNode prev = slow.next = null;
    while (second != null) {
        ListNode tmp = second.next;
        second.next = prev;
        prev = second;
        second = tmp;
    }

    //Re-assign the pointers to match the pattern
    ListNode first = head;
    second = prev;
    while (second != null) {
        ListNode tmp1 = first.next;
        ListNode tmp2 = second.next;
        first.next = second;
        second.next = tmp1;
        first = tmp1;
         second = tmp2;
        }
    }
}