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
    public int minDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null)
            return 0;
        ArrayList<TreeNode> bfs = new ArrayList<TreeNode>();
        ArrayList<Integer> depth = new ArrayList<Integer>();
        bfs.add(root);
        depth.add(1);
        int head = 0;
        while(head < bfs.size()){
            TreeNode curr;
            curr = bfs.get(head);
            int curr_depth = depth.get(head);
            head ++;
            if (curr.left == null && curr.right == null)
                return curr_depth;
            if(curr.left != null){
                bfs.add(curr.left);
                depth.add(curr_depth + 1);
            }
            if(curr.right != null){
                bfs.add(curr.right);
                depth.add(curr_depth + 1);
            }
        }
        return 0;
        
    }
}
