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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode node: lists){
            if(node!=null)
            q.offer(node);
        }
        ListNode top = q.poll();
        ListNode head = top;
        ListNode curr = head;
        while(curr!=null && top!=null){
            if(top.next!=null)
            q.add(top.next);
            top = q.poll();
            curr.next = top;
            curr = curr.next; 
        }

        return head;

    }
}
