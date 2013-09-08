public class Solution {
    private static int m,n;
    private static final char no_flip = 'n';
    private static char[][] board;
    private static void fill( int row, int column){
        if ( row >= m || row < 0 || column >= n || column < 0){
            return;
        }
        if ( board[row][column] != 'O'){
            return;
        }
        // mark current
        board[row][column] = no_flip;
        // fill four directions
        fill( row + 1, column);
        fill( row - 1, column);
        fill( row, column + 1);
        fill( row, column - 1);
    }
    
    public void solve(char[][] board) {
        // m rows n colunms board
        int i,j;
        this.board = board;
        m = board.length;
        if (m == 0){
            return;
        }
        n = board[0].length;
        for( i = 0; i < m; i ++){
            fill(i, 0);
            fill(i, n-1);
        }
        
        for( i = 0; i < n; i ++){
            fill( 0, i);
            fill( m-1, i);
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