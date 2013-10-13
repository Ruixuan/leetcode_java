public class Solution{
    public int singleNumber(int[] A){
        int n = A.length;
        
        long[] newA = new long[n];
        for(int i = 0; i < n ; i ++)
            newA[i] = A[i];// - Integer.MIN_VALUE;

        int[] bits = new int[33];
        for (int i = 0; i < 32; i ++)
            bits[i] = 0;
        for (long val: newA)
            for (int i = 0; i < 32; i++)
                bits[i] += (val >> i) & 1;
        long result = 0;                
        for (int i = 0; i < 32; i ++){
            if (bits[i] % 3 != 0)
                result = result | (1 << i);
        }

        return (int)(result);
    }
}
