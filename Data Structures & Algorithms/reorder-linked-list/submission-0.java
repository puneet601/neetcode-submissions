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
        Stack<ListNode> st = new Stack<>();
        ListNode trav = head;
        while (trav != null) {
            st.push(trav);
            trav = trav.next;
        }
        trav = head;
        while (trav != st.peek() && trav.next!=st.peek()) {
            ListNode temp = trav.next;
            trav.next = st.pop();
            trav = trav.next;
            trav.next = temp;
            trav = temp;
        }
        if(trav.next==st.peek())
        trav.next.next=null;
        else
        trav.next= null;
    }
}
