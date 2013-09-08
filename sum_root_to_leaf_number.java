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
    private int answer;
    private void travel(TreeNode root, int val){
        if ( root == null){
            return;
        }
        int new_val;
        new_val = val * 10 + root.val;
        if (root.left == null && root.right == null){
            answer += new_val;
            return;
        }
        travel(root.left, new_val);
        travel(root.right, new_val);       
    }
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        answer = 0;
        travel(root,0);
        return answer;
    }
}