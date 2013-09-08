public class Solution {
    private int m,n;
    private static final char no_flip = 'n';
    private void fill( char[][] board, int row, int column){
        if ( row >= m || row < 0 || column >= n || column < 0){
            return;
        }
        if ( board[row][column] != 'O'){
            return;
        }
        // mark current
        board[row][column] = no_flip;
        // fill four directions
        fill(board, row + 1, column);
        fill(board, row - 1, column);
        fill(board, row, column + 1);
        fill(board, row, column - 1);
    }
    
    public void solve(char[][] board) {
        // m rows n colunms board
        int i,j;
        m = board.length;
        if (m == 0){
            return;
        }
        n = board[0].length;
        for( i = 0; i < m; i ++){
            fill(board, i, 0);
            fill(board, i, n-1);
        }
        
        for( i = 0; i < n; i ++){
            fill(board, 0, i);
            fill(board, m-1, i);
        }
        // final fill
        for( i = 0; i < m; i ++){
            for( j = 0; j < n; j ++){
                if ( board[i][j] == no_flip){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
}