public class Solution {
    public int minCut(String s) {
        int i,l,j;
        boolean[][] is_pali;
        int[] dp;
        int length = s.length();
        // is pali[begin][end] tells us whether string s[begin, end ] a pali string
        is_pali = new boolean[length + 1][length + 1];
        // dp is the min cut of s[0..i]
        dp = new int[length];
        // initially, min cuts for string s is less than s.length()
        // also, string of length 1 is always pali
        for( i = 0; i < length; i ++){         
            is_pali[i][i] = true;
            if ( i < length -1){
                is_pali[i][i+1] = (s.charAt(i) == s.charAt(i+1) );
            }
        }
        // now we can calculate the is_pali
        // is_pali[i][j] = s[i] == s[j] && is_pali[i+1][j-1]
        // l is the length of substring
        for( l = 3; l <= length; l ++)
            for( i = 0; i <= length - l; i ++){
                j = i + l - 1;
                is_pali[i][j] = (s.charAt(i) == s.charAt(j)) && is_pali[i+1][j-1];              
            }       
        //calc dp
        dp[0] = 0;
        for( i = 1; i < length; i ++){
            dp[i] = i;
            if ( is_pali[0][i]){
                dp[i] = 0;
            }
            for(j = 0; j < i; j ++){
                if (is_pali[j+1][i] && (dp[j] + 1 < dp[i]) ){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp[length - 1];    
    }
}