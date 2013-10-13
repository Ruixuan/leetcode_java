public class Solution {
    public int singleNumber(int[] A) {
        int result;
        result = A[0];
        for(int i = 1; i < A.length; i ++)
            result = result ^ A[0];
        return result;
    }
}    
            
