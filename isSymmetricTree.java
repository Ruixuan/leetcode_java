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
    private boolean compare(TreeNode root_l,TreeNode root_r){
        if (root_l == null || root_r == null)
            return root_l == null && root_r == null;
        if ( root_l.val != root_r.val)
            return false;
        if (! compare( root_l.left, root_r.right))
            return false;
        return compare( root_l.right, root_r.left);
    }
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return compare(root, root);       
    }
}
