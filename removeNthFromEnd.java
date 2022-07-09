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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fastNode = dummy;
        ListNode slowNode = dummy;
        
        int i=0;
        while(fastNode != null && i <=n){
            fastNode = fastNode.next;
            i++;
        }
        
        while(fastNode != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummy.next;
        
    }
}