public class Solution {
    public int[] plusOne(int[] digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
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
            answer[len - 1] = 1;

        return answer;
    }
}
