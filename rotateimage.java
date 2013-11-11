public class Solution{
    public void rotate(int[][] matrix){
        int n, half;
        n = matrix.length;
      
        half = ( n ) / 2;
        for(int i = 0; i < n / 2 ; i ++)
            for(int j = 0; j < (n + 1) / 2; j ++){
                int tmp;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j - 1][i];
                matrix[n-j - 1][i] = matrix[n-i - 1][n-j - 1];
                matrix[n-i - 1][n-j - 1] =  matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
    }
} 
