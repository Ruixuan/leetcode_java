public class Solution {
    boolean visited[][];
    boolean found;
    char[][] board;
    int m, n, l;
    char[] word;
   
    int[] direct_i = new int[]{1,-1,0,0};
    int[] direct_j = new int[]{0,0,1, -1};
    
    private void dfs(int i, int j, int depth){
        if ( found ) return;
        
        
        if (board[i][j] != word[depth])
            return;
        
        if (visited[i][j]) return;
        
        if(depth == l - 1){
            found = true;
            return;
        }    
        
        visited[i][j] = true;
        
        for( int k = 0; k < 4; k ++){
            int i_new, j_new;
            i_new = i + direct_i[k];
            
            if ( i_new < 0 || i_new >= m)
                continue;
                
            j_new = j + direct_j[k];
            if ( j_new < 0 || j_new >= n)
                continue;
            dfs(i_new, j_new, depth + 1); 
        }
        
        visited[i][j] = false;
    }
    
    public boolean exist(char[][] board, String word) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        this.board = board;
        m = board.length;
        if (m == 0)
            return (word.length() == 0);
            
        n = board[0].length;
        this.word = word.toCharArray();
        l = word.length();
        
        // init visited array
        visited = new boolean[m][n];
        for( int i = 0; i < m; i ++)
            for( int j = 0; j < n; j ++)
                visited[i][j] = false;
        found = false;
        
        for( int i = 0; i < m; i ++)
            for( int j = 0; j < n; j ++){
                if (found) break;
                dfs(i, j, 0);
            }
            
        return found;
    }
}
