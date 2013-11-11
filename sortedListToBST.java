/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class Result{
        public TreeNode root;
        public ListNode tail;
        public Result(TreeNode root, ListNode tail){
            this.root = root;
            this.tail = tail;
        }
    }
    private Result buildTree(ListNode head, int len ){
        // given head and tail 
        Result result = new Result(null, head);
        if (head == null)
            return result;
        if (len <= 0)
            return result;
        TreeNode left, right;
        // travel left 
        Result l = buildTree(head, len  / 2);
        // create root 
        result.root = new TreeNode(l.tail.val);
        result.root.left = l.root;
        // travel right 
        Result r = buildTree(l.tail.next, len - len / 2 - 1);
        result.root.right = r.root;
        result.tail = r.tail;
        return result;
    }

    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int len;
        len = 0;
        ListNode ptr;
        ptr = head;
        while( ptr != null){
            ptr = ptr.next;
            len ++;
        }
        return buildTree(head, n).root;       
    }
}
