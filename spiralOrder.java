public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int m, n;
        n = matrix.length;
        if (n == 0)
            return answer;
        m = matrix[0].length;
        int layers = (Math.min(m, n) + 1) / 2;
        for(int l = 0; l < layers; l ++){
            // print hori 1
            for(int j = l; j < m - l; j ++)
                answer.add(matrix[l][j]);
            // print verti 1
            for(int i = l + 1; i < n - l - 1; i ++)
                answer.add(matrix[i][m - l - 1]);
            // print hori 2
            if (l < n - l - 1)
                for(int j = m - l - 1; j >= l ; j --)
                    answer.add(matrix[n - l - 1][j]);
            // print verti 2
            if (l < m - l - 1)
                for(int i =  n - l - 2; i >= l + 1; i --)
                    answer.add(matrix[i][l]);
        }
        return answer;
    }
}
