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
        curr = root;
        while(curr != null){
           if (curr.left != null)
               s.push(curr.left);
           if (curr.right != null){
               curr.left = curr.right;
               curr = curr.right;
           }else{
               curr.left = s.pop();
               curr = curr.left;
           }
        }
    }
}
