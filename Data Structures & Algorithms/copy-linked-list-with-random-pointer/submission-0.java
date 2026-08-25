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
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null)
        return null;
        Node copy = copyList(head);
        Node trav = copy;
        while(trav!=null){
            trav.random = map.get(trav.random);
            trav = trav.next;
        }

        return copy;

    }

    public Node copyList(Node head){
        if(head==null){
            return null;
        }

        Node trav = new Node(head.val);
        
        trav.next = copyList(head.next);
        trav.random = head.random;
        map.put(head,trav);
        return trav;
    }
}
