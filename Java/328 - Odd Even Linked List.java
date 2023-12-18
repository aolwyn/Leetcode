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
        - we want to separate odd and even nodes. the last odd node should point to the first even node.
        - we want O(1) space complexity and O(n) time complexity so must be done in 1 pass.
        - 1 base case, head is null or next node is null return head
        - general algorithm is as follows, set the curr odd and even nodes to head and head.next, set next node to 2 ahead (skip the even node to next odd node) and same for even 
        - when even / even.next is null, set the last odd node's next node to be the even head. return head because head was never changed.
        */

        if(head == null || head.next == null)
            return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even!= null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next; 
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}