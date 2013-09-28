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
    private int max;
    private int max_val(TreeNode root){
        if (null == root)
            return 0;
        int val_l, val_r;
        val_l = max_val(root.left);
        val_r = max_val(root.right);
        if (val_l + val_r + root.val > max)
            max = val_l + val_r + root.val;
        int ret_val;
        ret_val = root.val + val_l;
        if (ret_val < root.val + val_r)
            ret_val = root.val + val_r;
        if (ret_val < 0)
            ret_val = 0;
        return ret_val;
    }
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (null == root)
            return 0;
        max = root.val;
        max_val(root);
        return max;
        
    }
}
