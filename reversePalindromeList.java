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
    public boolean isPalindrome(ListNode head) {
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        
        boolean result = true;
        
        while(result && p2!=null){
            if(p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return result;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
    
    private ListNode endOfFirstHalf(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!= null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}