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
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int len,i;
        ListNode pt = head;
        if(pt == null)
            return;
        if(pt.next == null)
            return;
        // split the linkedlist by half
        len = 0;
        while(pt != null){
            len ++;
            pt = pt.next;
        }
        ListNode first, second;
        first = head;
        pt = head;
        for(i = 1; i < len / 2; i ++)
            pt = pt.next;
        second = pt.next;
        pt.next = null;
        // reverse second
        ListNode p1, p2;
        p1 = second;
        p2 = second.next;
        p1.next = null;
        while(p2 != null){
            pt = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = pt;
        }
        second = p1;
        pt = new ListNode(0);
        // merge first second
        p2 = second;
        p1 = first;
        while(p1 != null && p2 != null){
            pt.next = p1;
            p1 = p1.next;
            pt = pt.next;
            pt.next = p2;
            p2 = p2.next;
            pt = pt.next;
        }
        if (p1 != null)
            pt.next = p1;
            
        if(p2 != null)
            pt.next = p2;
    }
}
