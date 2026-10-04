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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode trav = head;
        int i = 0;
        ListNode newHead = null;
        ListNode prevEnd = null;
        ListNode end = null;
        while (i < k && trav != null) {
            trav = trav.next;
            i++;
            if (i == k) {
                 end = trav;
                ListNode curr = reverse(head, trav);
                if (newHead == null)
                    newHead = curr;
                if (prevEnd != null) {
                    prevEnd.next = curr;
                }
                prevEnd = head;

                head = end;
                trav = end;
                i = 0;
            }
            
        }
        if(i<k){
            prevEnd.next = end;
        }
        
        return newHead;
    }

    ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode next = null;

        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
