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
        int i=1;
        ListNode head=null;
        while(i<lists.length){
            if(head==null){
                head = mergeLists(lists[i-1],lists[i]);
            }else
            head = mergeLists(head,lists[i]);
            i++;
        }
        return head;
    }

    ListNode mergeLists(ListNode a, ListNode b){
        ListNode head = null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.val>=b.val){
            head = b;
            b=b.next;
        }else{
            head=a;
            a=a.next;
        }

        ListNode curr = head;

        while(a!=null && b!=null){
            if(a.val<=b.val){
                curr.next = a;
                a=a.next;
            }else{
                curr.next = b;
                b=b.next;
            }
            curr = curr.next;
        }
        if(a!=null){
            curr.next = a;
        }

        if(b!=null){
            curr.next = b;
        }
        return head;
    }
}
