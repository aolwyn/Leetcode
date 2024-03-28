class Solution {
    /*Algorithm:
    - we gonna use backtracking
    - we cant re-check things we've already visited so we need a way to keep track of visited elements
    - to check what we've visited, we can add to the value to put it inside / outside the value of ASCII.
    - when we've finished visiting all directions, we can return it to the usual value as the element can be used again.
    */
    private char[][] board; 
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 || board == null){
            return false;
        }
        this.board = board;

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(i,j,m,n,0,word))
                    return true;
            }
        }
        return false;
    }

    public boolean backtrack(int i, int j, int m, int n, int curr, String word){
        if(curr >= word.length())
            return true;
        
        if(i >=m || j >= n || i < 0 || j < 0 || board[i][j] != word.charAt(curr))
            return false;
        
        boolean exists = false;
        
        if(board[i][j] == word.charAt(curr)){
            board[i][j] += 100; 
            exists = backtrack(i, j+1, m, n, curr+1, word) ||
            backtrack(i, j-1, m, n, curr+1, word) || backtrack(i+1, j, m, n, curr+1, word) 
            || backtrack(i-1, j, m, n, curr+1, word);
            board[i][j] -=100;
        }
        return exists;
    }
}