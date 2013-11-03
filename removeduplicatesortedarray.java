public class Solution {
    public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int offset = 0;
        int n = A.length;
        for(int i = 1; i < n; i ++){
            if(A[i] == A[i-1])
                offset ++;
            else    
                A[i - offset] = A[i];
        }
        return n - offset;
    }
}
