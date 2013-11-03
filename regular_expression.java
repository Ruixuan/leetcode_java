public class Solution {
    private boolean match(char a, char b){
        if(a == '.' || b == '.')
            return true;
        return a == b;
    }
    public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m,n;
        m = s.length();
        n = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        for(int i = 0; i <= m; i ++)
            for(int j = 0; j <= n; j ++){
                dp[i][j] = false;
                if(i == 0 && j == 0)
                    dp[i][j] = true;
                    
                if(j == 0) continue;
                
                if(i == 0){
                    if(p.charAt(j - 1) == '*')
                        dp[i][j] |= dp[i][j - 2];
                    continue;
                }
                        
                if(p.charAt(j - 1) == '*')
                    dp[i][j] |= dp[i][j - 2] | (dp[i-1][j] && match(s.charAt(i-1), p.charAt(j - 2) ));
                else
                    dp[i][j] |= dp[i - 1][j - 1] && match(s.charAt(i-1),p.charAt(j - 1));
            }
        return dp[m][n];
    }
}
