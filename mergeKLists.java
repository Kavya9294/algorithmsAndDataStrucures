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
        PriorityQueue<ListNode> q = new PriorityQueue<>(( ListNode n1, ListNode n2) ->  n1.val - n2.val);
        ListNode head = null;
        for(ListNode list : lists){
            while(list != null){
                q.offer(list);
                list = list.next;
            }
        }
        if(q.isEmpty()){
            return head;
        }
        head = new ListNode(q.poll().val);
        ListNode cur = head;
        while(!q.isEmpty()){
            cur.next = new ListNode(q.poll().val);
            cur = cur.next;
        }
        
        return head;
    }
}