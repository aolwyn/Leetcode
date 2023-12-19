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
    public int pairSum(ListNode head) {
        /*Algorithm:
        - we can use fast and slow pointer to get to the end + middle of the list.
        - at this point, we want to reverse the linked list + use a 2 pointer or stack to find the twin sums.
        - alternatively, we could use a dequeue but it would take O(n) extra space.

        */
        if(head == null || head.next == null)
            return 0;

        ListNode slow = head;
        ListNode fast = head;
        int max = Integer.MIN_VALUE;
        ListNode prev = null;

        //get to middle + end of LL
        // we can do the reversal in the same loop.
        while(fast !=null && fast.next != null){

            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        //slow is at the middle of the list now and list has been reversed. we can now 2 pointer. the prev pointer is 1 behind slow looking towards head, slow is looking towards tail.
        
        while(prev != null || slow != null){
            int curr = prev.val+slow.val;
            max = Math.max(max, curr);
            prev = prev.next;
            slow = slow.next;
        }
            
        return max;
    }
}