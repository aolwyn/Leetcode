/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /*Algorithm:
        - we have a standard linked list construction (deep copy) but we also have a random pointer.
        - because of the random pointer, we need to do things in 2 passes (random ptr might not be to next node, adds difficulty.)
        - during the first pass, the first pass will create deep copy of the nodes of the original (no linking!).
        - the first pass will also map old node --> new node using a hashmap.
        - during the second pass, we will do all the linking. access the map's value for current node + update it's vals accordingly'

        - linear memory (O(n)) and 2(O(n)) time (2 passes)
        */
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();

        //pass 1: create new nodes, have the originals map to the second. 
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        //re-establish the head. pass 2: connect everything.
        //we use .get() to access the deep copy. after updating, iterate to next node
        curr = head;
        while(curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}