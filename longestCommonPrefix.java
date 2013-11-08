public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, asa
        // the same Solution instance will be reused for each test case.
        if (strs.length == 0)
            return null;
        len = 0;
        char curr;
        int flag = 1;
        while(flag == 1 && len < strs[0].length()){
            curr = strs[0].charAt(len);
            for(String s:strs)
                if (s.length() <= len || s.charAt(len) != curr)
                    flag = 0;
            if (flag == 1)
                len ++;
        }
        return len;
    }
}
