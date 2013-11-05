public int rand(int[] a, int N){
    // a is sorted
    // generate a rand number k which is in range [0, N)
    // p = 1/(N-length) 
    // int uniform(int N) returns rand number [0, N)
    // do it in O(N) time and O(1) space
    int len = a.length;
    int r = uniform(N - len) + 1;
    int  pre = 0;
    for(int i = 0; i < len; i ++){
        int range_len = a[i] - pre;
        // check the range [pre, a[i])
        if(range_len >= r){
            return pre + r - 1;            
        }
        r = r - range_len;
        pre = a[i] + 1;
    }
    return pre + r - 1;
}
