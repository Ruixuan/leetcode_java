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
    TreeNode n1, n2, pre;
    
    private void travel(TreeNode root){
        if(root == null)
            return;
        travel(root.left);
        if (pre != null){
            if (pre.val > root.val){
                if(n1 == null)
                    n1 = pre;
                n2 = root;
            }
        }
        pre = root;
        travel(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        n1 = null;
        n2 = null;
        pre = null;
        travel(root);
        int tmp;
        tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
 
    }
}
