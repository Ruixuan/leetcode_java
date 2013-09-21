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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head,tail;
        // this is a virtual header, the true list begins at head.next
        head = new ListNode(0);
        tail = head;
        int min_index = -1;
        int min_val = 9999999;
        do{
           for(i = 0; i < lists.size(); i++ ){
             if ( lists[i] == null)
                 continue;
             if ( lists[i].val > min_val){
                min_val = lists[i].val;
                min_index = i;
             }
           }
           if ( min_index < 0) break;
           tail.next = lists[min_index];
           tail = tail.next;
           lists[min_index] = lists[min_index].next;
        }while( min_index >= 0);
        tail.next = null;
        return head.next;
    }
}
