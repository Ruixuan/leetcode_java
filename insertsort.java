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
    private void insert(ListNode newNode, ListNode sorted){
        ListNode curr;
        curr = sorted;
        while(curr.next != null){
            if (curr.next.val > newNode.val)
                break;
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }
    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode sorted, ptr;
        sorted = new ListNode(-99999);
        ptr = head;
        sorted.next = null;
        while(ptr != null){
            ListNode tmp = ptr.next;
            insert(ptr, sorted);
            ptr = tmp;
        }
        return sorted.next;
    }
}
