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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> answer = new ArrayList<Integer>();
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(null);
        while(curr != null){
            answer.add(curr.val);
            if (curr.right != null)
                s.push(curr.right);
                
            if (curr.left != null)
                curr = curr.left;
            else 
                curr = s.pop();
        }
        return answer;
    }
}
