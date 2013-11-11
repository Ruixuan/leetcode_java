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
    private TreeNode flat(TreeNode root, TreeNode tail){
        if (root == null)
            return null;

        TreeNode l, r;
        r = flat(root.right, root);
        l = flat(root.left, tail);
        if (l == null)
            root.left = tail;

        root.right = null;
        if(r != null)
            return r;
        else 
            return root;

    }

    public void flatten(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return flat(root, null);
    }
}
