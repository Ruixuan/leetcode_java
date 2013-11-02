public class Solution {
    public boolean isScramble(String s1, String s2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length()) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for(int i = 0; i < s1.length(); i ++)
            if (arr1[i] != arr2[i])
                return false;
        int n = s1.length();
        for(int i = 0; i < n - 1; i ++){
            if( isScramble(s1.subString(0, i + 1), s2.subString(0, i + 1) &&
                isScramble(s1.subString(i+1), s2.subString(i+1)) )
                return true;
                    
            if( isScramble(s1.subString(0,i+1), s2.subString(n - i - 1)) &&
                isScramble(s1.subString(i+1), s2.subString(0, n - i - 1))
                return true;
        }
        return false;
    }
}
