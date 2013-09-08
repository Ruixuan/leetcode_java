public class Solution {
    private class Point{
        public int row, column;
        public Point(int row, int column){
            this.row = row;
            this.column = column;
        }
    }
    ArrayList<Point> bfs;
    private static final char no_flip = 'n';

    int m,n;
    char[][] board;
    
    public void add(int row, int column){
        if ( row >= m || row < 0 || column >= n || column < 0){
            return;
        }
        if ( board[row][column] != 'O'){
            return;
        }    
        board[row][column] = no_flip;
        Point tmp = new Point(row, column);
        bfs.add(tmp);
    }
    
    public void solve(char[][] board) {
        int i,j;
        bfs = new ArrayList<Point>();
        this.board = board;
        m = board.length;
        if (m == 0){
            return;
        }
        n = board[0].length;
        
        for( i = 0; i < m; i ++){
            add(i, 0);
            add(i, n-1);
        }
        
        for( i = 0; i < n; i ++){
            add( 0, i);
            add( m-1, i);
        }
        Point curr;
        int row,column;
        int ptr;
        ptr = 0;
        while(ptr < bfs.size()){
            curr = bfs.get(ptr);
            ptr ++;
            row = curr.row;
            column =curr.column;
            add(row + 1, column);
            add(row - 1, column);
            add(row, column + 1);
            add(row, column - 1);   
        }
        
        for( i = 0; i < m; i ++){
            for( j = 0; j < n; j ++){
                if (board[i][j] == 'X'){
                    continue;
                }
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