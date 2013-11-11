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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        TreeNode pre, curr;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(null);
        ArrayList<Integer> answer = new ArrayList<Integer>();
        pre = new TreeNode(1);
        curr = root;
        while(!s.isEmpty()){
            if (curr != null){
                if(curr.right == pre){
                    // right has been traveled
                    answer.add(curr.val);
                }else{
                    s.push(curr);
                    if(pre != curr.left)
                        s.push(curr.left);
                    else
                        s.push(curr.right);
                }
            }
            pre = curr;
            curr = s.pop();
       }
       return answer;   
    }
}
