public class Solution{
    private int max(int a, int b){
        if ( a > b) return a;
            else return b;
    }

    private int get_val(int[][] dp, int i, int j){
        if ( i < 0 || j < 0)
            return 0;
        else
            return dp[i][j];
    }
    
    private int abs(int a){
        if (a < 0) return -a;
            else return a;
    }

    public int minDistance(String word1, String word2){
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int m = w1.length;
        int n = w2.length;
        if ( m == 0 || n == 0)
            return abs(m - n);
            
        int[][] dp = new int[m][n];
        for( int i = 0; i < m; i ++)
            for( int j = 0; j < n; j ++){
                dp[i][j] = 0;
                if ( w1[i] == w2[j])
                    dp[i][j] = max(dp[i][j], get_val(dp, i - 1, j - 1) + 1);
                dp[i][j] = max(dp[i][j], max(dp[i - 1][j], dp[i][j - 1]));
            }

        return abs(m - n) + dp[m - 1][n - 1];    

    }
}
