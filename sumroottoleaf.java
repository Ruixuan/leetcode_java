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
    int answer;
    private void travel(TreeNode root, int val){
        if (root == null)
            return;
        
        val = val * 10 + root.val;
        
        if (root.right == null && root.left == null){
            answer += val;
            return;
        }
        
        
        travel(root.left, val);
        travel(root.right, val);
        
    }
    public int sumNumbers(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        answer = 0;
        travel(root, 0);
        return answer;
        
    }
}
