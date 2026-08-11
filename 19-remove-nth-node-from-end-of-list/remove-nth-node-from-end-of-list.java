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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> l = new ArrayList<>();
        ListNode tmp = head;
        while(tmp!=null){
            l.add(tmp.val);
            tmp=tmp.next;
        }
        int in = l.size()-n;
        l.remove(in);
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for(int v:l){
            ListNode node = new ListNode(v);
            tail.next = node;
            tail=node;
        }
        return dummy.next;
    }
}