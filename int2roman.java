public class Solution{
    public String intToRoman(int num){
        int[] val = new int[]{1000, 900, 500, 400,  100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str ={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int i;
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            if( val[i] > num)
                i ++;
            else
                sb.append(str[i]);
        }
        return sb.toString();
    }
}
