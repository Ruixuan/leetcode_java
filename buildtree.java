
public class Solution {
    HashMap<Integer,Integer> index_map;
    int[] preorder;
    int[] inorder;
    TreeNode build(int head_p, int tail_p, int head_i, int tail_i){
        if ( head_p > tail_p)
            return null;
        TreeNode root = new TreeNode(preorder[head_p]);
        int index_root = index_map.get(root.val);
        int left_len = index_root - head_i;
        int right_len = tail_i - index_root;
        root.left = build(head_p + 1, head_p + left_len, head_i, index_root - 1);
        root.right = build(head_p + left_len + 1, tail_p, index_root + 1, tail_i);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        index_map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i ++)
            index_map.add( inorder[i], i );
        this.preorder = preorder;
        this.inorder = inorder;
        return build( 0, n - 1, 0 , n - 1); 
        
    }
}    
