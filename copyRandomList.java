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
    Map<Node, Node> visitedMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        if( this.visitedMap.containsKey(head) )
            return this.visitedMap.get(head);
        
        Node node = new Node(head.val);
        
        visitedMap.put(head, node);
        
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        
        return node;
    }
}