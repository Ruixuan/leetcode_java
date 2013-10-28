public class Solution {
    public int firstMissingPositive(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i = 0, tmp;
        while( i < A.length){
            while(A[i] > 0 && A[i] < A.length){
                tmp = A[i];
                if (A[tmp] == A[i])
                    break;
                A[i] = A[tmp];
                A[tmp] = tmp;
            }
            i ++;
        }
        for(int i = 1; i < A.length; i ++)
            if (A[i] != i)
                return i;
        return A.length;
        
    }
}
