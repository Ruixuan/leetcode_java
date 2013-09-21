public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    int i,n,answer;
    n = A.length;
    if ( n == 0) 
        return 0;
    int[] max = new int[n];
    max[0] = A[0];
    answer = A[0];
    for( i = 1; i < n; i++){
        if (max[i-1] >0) max[i] = A[i] + max[i-1];
                    else max[i] = A[i];
        if (max[i] > answer) answer = max[i];
    }

    return answer;
   }	

}
