/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode slow, fast;
        slow = head;
        fast = head;
        while( slow != null && fast != null){
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;
            if (slow == fast)
                break;
        }
        if (slow == null || fast == null)
            return null;
        fast = head;
        while( fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
