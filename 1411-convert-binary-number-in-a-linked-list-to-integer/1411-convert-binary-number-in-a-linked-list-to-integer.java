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
    public int getDecimalValue(ListNode head) {
        int ans=0;
        while(head!=null) {
            if(head.val==0) {
                ans = (ans<<1) | 0;
            }else{
                ans = (ans<<1) | 1;
            }
            head=head.next;
        }
        return ans;
    }
}