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
         if(head==null || head.next==null)
        return;
        ListNode slow = head;
       
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode root = revert(slow.next);
        slow.next = null;
        slow = head;
        int count = 0;
        while (slow.next != null) {
            ListNode slowNext = slow.next; 
            ListNode rootNext = root.next; 
            slow.next = root;
            root.next = slowNext;
            slow = slowNext;
            root = rootNext;
        }
        slow.next = root;
        slow = head;

    }

    ListNode revert(ListNode root) {
        if (root == null)
            return null;

        ListNode head = new ListNode();
        ListNode prev = head;
        prev.next = root;
        ListNode curr = root;
        while (curr != null) {
            ListNode next = curr.next;
            if(prev!=head)
            curr.next = prev;
            else
            curr.next=null;
        
            prev = curr;
            curr = next;
        }

        head = null;

        return prev;
    }
}
