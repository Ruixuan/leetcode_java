class Solution {
    public int solution(int[] A) {
        // write your code here...
        int n = A.length;
        long[] sum = new long[n];
        if (n > 0)
            sum[0] = A[0];
        else
            return -1;
        for(int i = 1; i < n; i ++)
            sum[i] = sum[i -1] + A[i];
        long total = sum[n - 1];
        int answer = 0;
        for(int i = 0; i < n ; i ++)
            if ( total - sum[i] == sum[i] - A[i])
                return i;
        return -1;   
    }
}
