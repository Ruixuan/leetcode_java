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
    private class MyComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode a, ListNode b){
            return a.val - b.val;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (lists == null || lists.size() == 0)
            return null;
        int n;
        n = lists.size();
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(n, new MyComparator());
        for(ListNode one_list: lists){
            if (null != one_list)
                    q.offer(one_list);
        }
        ListNode answer = new ListNode(0);
        ListNode pt = answer;
        while(null != q.peek()){
            ListNode curr_node = q.poll();
            pt.next = curr_node;
            if (curr_node.next != null)
                q.offer(curr_node.next);
            pt = pt.next;
            pt.next = null;
        }
        return answer.next;
    }
}
