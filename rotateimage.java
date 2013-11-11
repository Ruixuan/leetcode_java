public class Solution{
    public void rotate(int[][] matrix){
        int n, half;
        n = matrix.length;
        half = ( n + 1 ) / 2;
        for(int i = 0; i < half; i ++)
            for(int j = 0; j <half; j ++){
                int tmp;
                next = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] =  matrix[j][n - i];
                matrix[j][n - i] = tmp;
            }
    }
}
