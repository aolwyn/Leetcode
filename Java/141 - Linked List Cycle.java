/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /*Algorithm:
        - use fast and slow pointer, if they ever meet, cycle exists
        - if not, then no cycle
        */
        if(head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
             if(slow == fast) //has to be down here otherwise it says true bc of first iteration.
                return true;
        }
        return false;
    }
}