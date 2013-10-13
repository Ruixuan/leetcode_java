public class Solution{
    public int singleNumber(int[] A){
        int[] bits = new int[33];
        for (int i = 0; i < 32; i ++)
            bits[i] = 0;
        for (int val: A)
            for (int i = 0; i < 32; i++)
                bits[(val << i) & 1] ++;
        int result = 0;                
        for (int i = 0; i < 32; i ++){
            result = result << 1;                
            if (bits[i] % 3 != 0)
                result = result | 1;
        }
        return result;
    }
}
