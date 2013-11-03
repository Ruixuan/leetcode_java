/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode before_break, new_tail, new_head, after_break, pre, next;
        ListNode v = new ListNode(0);
        v.next = head;
        int i;
        before_break = v;
        for(i = 0; i < m - 1; i ++)
            before_break = before_break.next;
            
        new_tail = before_break.next;
        pre = new_tail;
        next = pre.next;
        for( i = m; i < n; i ++){
            ListNode tmp;
            tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        new_head = pre;
        after_break = next;
        before_break.next = new_head;
        new_tail.next = after_break;
        return v.next;
    }
}
