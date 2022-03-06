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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode head = dummyHead;
        int carry=0, sum=0;
        
        while(l1!=null || l2!=null){
            int p = (l1!=null) ? l1.val : 0;
            int q = (l2!=null) ? l2.val : 0;
            sum = carry+p+q;
            ListNode curr = new ListNode(sum%10);
            head.next=curr;
            head = curr;
            carry = sum/10;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry > 0){
            head.next = new ListNode(carry);
        }
        
        return dummyHead.next;
    }
}