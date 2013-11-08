public class Solution {
    private void reverse(char[] digits){
         for(int i = 0; i < digits.length / 2; i ++){
            char tmp = digits[i];
            digits[i] = digits[ digits.length - 1 - i];
            digits[ digits.length - 1 - i] = tmp;
         }
    }

    private int char2int(char a){
        return (int)(a - '0');
    }

    public String multiply(String num1, String num2){
        int m = num1.length();
        int n = num2.length();
        char[] digits1 = num1.toCharArray();
        char[] digits2 = num2.toCharArray();
        reverse(digits1);
        reverse(digits2);
        int[] tmp = new int[m + n + 1];
        for(int i = 0; i < m + n + 1; i ++)
            tmp[i] = 0;
        for(int i = 0; i < m; i ++){
            int val1 = char2int(digits1[i]);
            for(int j = 0; j < n; j ++){
                int val2 = char2int(digits2[j]);
                tmp[i + j] += val1 * val2;
            }
        }

        for(int i = 0; i < tmp.length - 1; i ++){
            tmp[i + 1] += tmp[i] / 10;
            tmp[i] = tmp[i] % 10;
        }

        int i = tmp.length - 1;
        while(tmp[i] == 0 && i > 0 )
            i --;

        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            sb.append(tmp[i]);
            i --;
        }
        return sb.toString();
    }
}
