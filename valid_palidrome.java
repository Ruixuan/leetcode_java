public class Solution {
    private boolean not_alpha(char a){
        return !( (a >= 'a' && a <='z' ) || (a >= 'A' && a <='Z') || (a >= '0' && a <= '9'));
    }
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int head, tail;
        boolean flag;
        s = s.toLowerCase();
        flag = true;
        head = 0;
        tail = s.length() - 1;
        while(head < tail){
            while(head < tail && not_alpha(s.charAt(head))) head ++;
            while(head < tail && not_alpha(s.charAt(tail))) tail --;
            if (head < tail)
                if (s.charAt(head) != s.charAt(tail)){
                    flag = false;
                    break;
                }
            head ++;
            tail --;
        }
        return flag;
        
    }
}
