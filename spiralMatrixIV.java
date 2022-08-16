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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int[] dr = { 0, 1, 0, -1};
        int[] dc = { 1, 0, -1, 0};
        
        int[][] ans = new int[m][n];
        
        int d = 0, r = 0, c = 0;
        boolean[][] visited = new boolean[m][n];
        int t = 1;
        ans[0][0] = head == null? -1 : head.val;
        visited[0][0] = true;
        if(head != null){
            head = head.next;
        }
        while(t < ((m)*(n))){
            
            int newR =r + dr[d];
            int newC =c + dc[d];
            if(newR >= 0 && newC >= 0 && newR < m && newC < n && !visited[newR][newC]){
                int val = head == null? -1 : head.val;
                if(head != null){
                    head = head.next;
                }
                r = newR;
                c = newC;
                ans[r][c] = val;
                visited[r][c] = true;
                t++;
            }else{
                d = (d+1)%4;
            }
            
        }
        return ans;
    }
}