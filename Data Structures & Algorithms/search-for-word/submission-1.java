class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean visited[][]=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(board,word,i,j,0,visited))
                return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int r, int c, int i, boolean[][] visited){
        if(i==word.length()){
            return true;
        }

        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c] || board[r][c]!=word.charAt(i))
        return false;

        visited[r][c]=true;
        if(dfs(board,word,r+1,c,i+1,visited)||dfs(board,word,r,c+1,i+1,visited)||dfs(board,word,r-1,c,i+1,visited)||dfs(board,word,r,c-1,i+1,visited))
        return true;

        visited[r][c]=false;
        return false;
    }
}
