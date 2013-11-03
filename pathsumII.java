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
    private ArrayList<ArrayList<Integer>> answer;
    private LinkedList<Integer> one_answer;
    private void find_path(TreeNode root, int sum){
        if (root == null)
            return;
        if (root.right == null && root.left == null){
            if(sum == root.val){
                one_answer.addLast(sum);
                answer.add(new ArrayList<Integer>(one_answer));
                one_answer.removeLast();
            }
            return;
        }
        one_answer.addLast(root.val);
        find_path(root.right, sum - root.val);
        find_path(root.left, sum - root.val);
        one_answer.removeLast();
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        answer = new ArrayList<ArrayList<Integer>>();
        one_answer = new LinkedList<Integer>();
        find_path(root, sum);
        return answer;
    }
}
