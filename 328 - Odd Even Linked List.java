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
    public ListNode oddEvenList(ListNode head) {
        /*Algorithm:
        - We are required to put all 'odd' numbered nodes at start, even at the end.
        - we need an algorithm using constant space and linear time (O(1), O(n) respectively)
        - we will have a head for the positive and a head for the negative. build both then connect.
        - loop condition based on even head (even is end of list).
            --> the algorithm is as follows:
                - set the next odd node to the node following the even node (even.next). ( think odd, even, odd recurring).
                - set current odd node to next odd node.
                - repeat for the even node (even.next = odd.next)
                - set current even node to next even node.
        - 1 base case, null head or no next node.
        */
        if(head == null || head.next == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}