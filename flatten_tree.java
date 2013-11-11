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
    public void flatten(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(null);
        TreeNode curr = root;

        while(curr != null){
           if (curr.right != null)
               s.push(curr.right);
           TreeNode next;
           if (curr.left != null){
               next = curr.left;
           }else{
               next = s.pop();
           }
           curr.right = next;
           curr.left = null;
           curr = next;
        }

    }
}
