public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int i,j;
		int n = s.length();
		int[] dp = new int[n];
		for(i = 0; i < n; i ++){
			//
			dp[i] = 0;
			if (dict.contains(s.substring(0,i+1))){
				dp[i] = 1;
				continue;
			}
				
			for( j = 0; j < i; j ++)
				if (dp[j] == 1)
					if (dict.contains(s.substring(j+1,i+1))){
						dp[i] = 1;
						continue;
					}
		}
		
		return dp[n - 1] == 1;
			
    }
}
