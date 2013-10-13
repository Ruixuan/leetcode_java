public class Solution{
    public int singleNumber(int[] A){
        int n = A.length;
        
        long[] newA = new long[n];
        for(int i = 0; i < n ; i ++)
            newA[i] = A[i] - Integer.MIN_VALUE;

        int[] bits = new int[33];
        for (int i = 0; i < 32; i ++)
            bits[i] = 0;
        for (int val: newA)
            for (int i = 0; i < 32; i++)
                bits[i] += (val >> i) & 1;
        int result = 0;                
        for (int i = 0; i < 31; i ++){
            if (bits[i] % 3 != 0)
                result = result | (1 << i);
        }

        return result + Integer.MIN_VALUE;
    }
}
