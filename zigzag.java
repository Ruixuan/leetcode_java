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
    
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> answer = new rrayList<ArrayList<Integer>>();
        if (root == null)
            return answer;
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        LinkedList<TreeNode> pre = new LinkedList<TreeNode>();
        int order = 0;
        pre.add(root);
        
        while(pre.size() != 0){
            ArrayList<Integer> one_line = new ArrayList<Integer>();
            for(TreeNode curr:pre){
                if(curr.left != null)
                    next.add(curr.left);
                if(curr.right != null)
                    next.add(curr.right);
                one_line.add(curr.val);
            }
            if(order == 1)
                Collections.reverse(one_line);
            answer.add(one_line);
            order = 1 - order;
        }
        return answer;
    }
}
