public class Solution {
public int firstMissingPositive(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i = 0, tmp;
        while( i < A.length){
            while(A[i] > 0 && A[i] <= A.length){
                tmp = A[i];
                if (A[tmp - 1] == A[i])
                    break;
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
            i ++;
        }
        for( i = 0; i < A.length; i ++)
            if (A[i] != i + 1)
                return i + 1;
        return A.length + 1;
        
    }
}
