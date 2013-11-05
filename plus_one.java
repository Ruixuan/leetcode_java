public class Solution {
    private void reverse(int[] a){
        int len = a.length;
        for(int i = 0; i < len/2; i ++){
            int tmp = a[i];
            a[i] = a[len - i - 1];
            a[len - i - 1] = tmp;
        }
    }
    public int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        reverse(digits);
        int len = digits.length;
        int flag = 1;
        // to check if all number equals 9
        for(int val:digits)
            if(val != 9)
                flag = 0;
                
        len += flag;
        
        int[] answer = new int[len];
        int inc = 1;
        
        for(int i = 0; i < digits.length; i ++){
            answer[i] = digits[i] + inc;
            if( answer[i] >= 10){
                answer[i] -= 10;
                inc = 1;
            }else
                inc = 0;
        }

        if(inc == 1)
            answer[digits.length] = 1;
        reverse(answer);
        return answer;
    }
}
