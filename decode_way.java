public class Solution {
    public int numDecodings(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s.length() == 0) 
            return 0;
        HashSet<String> valid_code = new HashSet<String>();
        for(int i = 1; i <= 26; i ++)
            valid_code.add(Integer.toString(i));
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for(int i = 1; i <= s.length(); i ++){
            dp[i] = 0;
            if( i > 1)
                if ( valid_code.contains(s.substring(i - 2, i)))
                    dp[i] += dp[i - 2];
            if (valid_code.contains(s.substring(i - 1, i)))
                    dp[i] += dp[i - 1];
                        
        }
        return dp[s.length()];
    }
}
