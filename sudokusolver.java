public class Solution {
    int m, n;
    char[][] map;
    boolean found;
    ArrayList<HashSet<Character> > row;
    ArrayList<HashSet<Character> > col;
    ArrayList<HashSet<Character> > mat;
    
    private int convert(int i, int j){
        return (i / 3) * 3 + ( j / 3);
    }
    
    private void fill(int i, int j){
        if (found)
            return;
            
        if( j >= m){
            j = j - m;
            i ++;
        }
        if ( i >= n){
            found = true;
            return;
        }
        
        if( map[i][j] != '.'){
            fill(i, j + 1);
            return;
        }
        
        for(char c = '1'; c <= '9'; c ++){
            if ( row.get(i).contains(c) || col.get(j).contains(c) || mat.get(convert(i,j)).contains(c))
                continue;
            row.get(i).add(c);
            col.get(j).add(c);
            mat.get(convert(i, j)).add(c);
            map[i][j] = c;
            fill(i, j + 1);
            if (found)
                return;
            // back trace
            map[i][j] = '.';
            row.get(i).remove(c);
            col.get(j).remove(c);
            mat.get(convert(i, j)).remove(c);            
        }        
    }
    
    public void solveSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        m = board.length;
        n = board[0].length;
        map = board;
        row = new ArrayList<HashSet<Character> >();
        col = new ArrayList<HashSet<Character> >();
        mat = new ArrayList<HashSet<Character> >();
        for(int i = 0; i < n; i ++){
           row.add(new HashSet<Character>()); 
           col.add(new HashSet<Character>());
           mat.add(new HashSet<Character>());
        }
        // build map
        for( int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)                 
                if(board[i][j] != '.'){
                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    mat.get(convert(i,j)).add(board[i][j]);
                }
            
        found = false;
        fill(0,0);        
        return;              
    }
}
