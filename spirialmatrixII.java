public class Solution {
    public int[][] generateMatrix(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[][] answer = new int[n][n];
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++)
                answer[i][k] = 0;
        int i,j;
        i = 0; 
        j = 0;
        int direct_i = 0;
        int direct_j = 1;
        for(int curr = 1; curr <= n*n; curr ++){
            if ( i < 0 || j < 0 || i >= n || j >= n || answer[i][j] != 0){
                // recover i j 
                i -= direct_i;
                j -= direct_j;
                // change direction
                if (direct_i != 0){
                    direct_j = - direct_i;
                    direct_i = 0;
                }else{
                    direct_i = direct_j;
                    direct_j = 0;
                }
                // give i j the right direction
                i += direct_i;
                j += direct_j;
            }
            answer[i][j] = curr;
            i += direct_i;
            j += direct_j;
        }
        return answer;
    }
}
