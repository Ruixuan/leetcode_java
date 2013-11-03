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
    boolean flag;
    private int depth(TreeNode root){
        if(root == null) return 0;
        int l,r;
        l = depth(root.left);
        r = depth(root.right);
        if (Math.abs(l - r) > 1)
            flag = false;
        return Math.max(l, r) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
       
        flag = true;
        depth(root);
        return flag;
    }
}
