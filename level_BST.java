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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> bfs = new ArrayList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        ArrayList<Integer> curr_level_list = new ArrayList<Integer>();
        bfs.add(root);
        level.add(0);
        int index = 0;
        TreeNode curr;
        Integer curr_level = 0;
        while(index < bfs.size()){
            curr = bfs.get(index);
            if ( level.get(index).equals(curr_level)){
                curr_level_list.add(Integer(curr.val));
            }else{
                answer.add(curr_level_list);
                curr_level_list = new ArrayList<Integer>();
                curr_level += 1;
                curr_level_list.add(curr_level);
            }
            //add left
            if ( curr.left != null){
                bfs.add(curr.left);
                level.add(curr_level + 1);
            }
            if ( curr.right != null){
                bfs.add(curr.right);
                level.add(curr_level + 1);
            }
            index ++;
        }
        answer.add(curr_level_list);
        return answer;
    }
}
