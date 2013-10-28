public class Solution {
    public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i, j, m, n;
        int flag_i = 1, flag_j = 1;
        m = matrix.length;
        if (m == 0) return;
        
        n = matrix[0].length;
        
        for(i = 0; i < m; i ++)
            if (matrix[i][0] == 0)
                flag_i = 0;
                
        for( j = 0; j < n; j ++)
            if (matrix[0][j] == 0)
                flag_j = 0;
                
        
        for( i = 1; i < m; i ++)
            for( j = 1; j < n; j ++)
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        // now set rows
        for( i = 1; i < m; i ++)
            if ( matrix[i][0] == 0)
                for(j = 1; j < n; j ++)
                    matrix[i][j] = 0;
                    
        // colunms            
        for( j = 1; j < n; j ++)
            if ( matrix[0][j] == 0)
                for(i = 1; i < m; i ++)
                    matrix[i][j] = 0;
        
        if (flag_i == 0)
            for( i = 0; i < m; i ++)
                matrix[i][0] = 0;
        
        if (flag_j == 0)
            for(j = 0; j < n; j ++)
                matrix[0][j] = 0;
                
        return;
        
    }
}
