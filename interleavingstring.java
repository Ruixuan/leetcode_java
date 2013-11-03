public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m, n;
        m = s1.length();
        n = s2.length();
        if(m + n != s3.length())
            return false;
        boolean dp[][] = new int[m+1][n+1];
        for(int i = 0; i <= m; i ++)
            for(int j = 0; j <= n; j ++)
                dp[i][j] = false;
        dp[0][0] = true;
        for(int i = 1; i <= m; i ++)
            for(int j = 1; j <= n; j ++){
                if(s1.charAt(i-1) == s3.charAt(i+j-1))
                    dp[i][j] |= dp[i-1][j];
                if(s1.charAt(j-1) == s3.charAt(i+j-1))
                    dp[i][j] |= dp[i][j-1];
            }
        return dp[m][n];
    }
}
