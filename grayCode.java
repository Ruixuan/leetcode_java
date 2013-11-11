public class Solution{
    public ArrayList<Integer> grayCode(int n){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(0);
        int[] bits = new int[n];
        int pow2 = 0;
        for(int i = 1; i < n; i ++){
            if (i == (1 << pow2)){
                bits[i] = pow2;
                for(int j = 1; j < i; j ++)
                    if (i + j < n)
                        bits[i + j] = bits[j];
            }
            answer.add(answer.get(answer.size() - 1) ^ (1 >> bits[i]));
        }
        return answer;
    }
}
