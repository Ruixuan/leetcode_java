public class Solution {
    public int numDistinct(String S, String T) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[] s = S.toCharArray();
        char[] t= T.toCharArray();
        if (s.length == 0 || t.length == 0)
            return 0;
        int[][] dp = new int[s.length + 1][t.length + 1];
        //dp[i][j] number of subsequnce of s[:i] t[:j]
        // if s[i] != t[j]: dp[i][j] = dp[i-1][j]
        // else dp[i][j] = dp[i - 1][j] + dp[i-1][j - 1]
        dp[0][0] = 1;
        for(int i = 0; i < s.length + 1; i ++)
            dp[i][0] = 1;
        for(int j = 1; j < t.length + 1; j ++)
            for(int i = j; i < s.length + 1; i ++)
                if (s[i-1] == t[j - 1]){
                    dp[i][j] = dp[i -1][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
        return dp[s.length][t.length];
    }
}
