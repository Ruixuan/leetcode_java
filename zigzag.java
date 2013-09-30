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
    private LinkedList<TreeNode> bfs;
    private LinkedList<Integer> levels;
    private void put(TreeNode root, int level){
        if (null != root){
            bfs.add(root);
            levels.add(level);
        }
    }

    private void bfs_search(TreeNode root){
        levels = new LinkedList<Integer>();
        answer = new ArrayList<ArrayList<Integer>>();
        bfs = new LinkedList<TreeNode>();
        ArrayList<Integer> one_level = new ArrayList<Integer>();
        ArrayList<Integer> one_answer = new ArrayList<Integer>();
        int pre_level = 0;
        put(root, 0);
        
        while(!bfs.isEmpty()){
            TreeNode curr = bfs.remove();
            int curr_level = levels.remove();
            if (curr_level != pre_level){
                if (pre_level % 2 == 1)
                    Collections.reverse(one_answer);
                answer.add(one_answer);
                one_answer = new ArrayList<Integer>();
                pre_level = curr_level;
            }
            one_answer.add(curr.val);
            put(curr.left, curr_level + 1);
            put(curr.right, curr_level + 1);
        }
        answer.add(one_answer);
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        bfs_search(root);
        return answer;
    }
}
