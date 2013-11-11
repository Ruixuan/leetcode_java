public class Solution {
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int head, tail;
        boolean flag;
        flag = true;
        head = 0;
        tail = s.length() - 1;
        while(head < tail){
            while(head < tail && s.charAt(head) == ' ') head ++;
            while(head < tail && s.charAt(tail) == ' ') tail --;
            if (head < tail)
                if (s.charAt(head) != s.charAt(tail)){
                    flag = false;
                    break;
                }
        }
        return flag;
        
    }
}
