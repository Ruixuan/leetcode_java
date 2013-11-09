Class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}


TreeNode build(int A[], int start, int end){
    if (start > end)
       return null;
    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(A[mid]);
    root.right = build(A, start, mid - 1);
    root.left = build(A, mid + 1, end);
    return root;
}

void build_bst(int A[]){
    Arrays.sort(A);
    return  build(A, 0, A.length);
}
