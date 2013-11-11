public class Solution{
    public ArrayList<Integer> grayCode(int n){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(0);
        if (n == 0)
            return answer;
        int m = 1 << n ;
        int[] bits = new int[m];
        int pow2 = 0;
        for(int i = 0; i < m - 1; i ++){
            if (i + 1 == (1 << pow2)){
                bits[i] = pow2;
                pow2 ++;
                for(int j = 0; j < i; j ++)
                    if (i + j + 1 < m)
                        bits[i + j + 1] = bits[j];
            }
            answer.add(answer.get(answer.size() - 1) ^ (1 << bits[i]));
        }
        return answer;
    }
}
