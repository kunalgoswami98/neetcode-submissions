class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0)){
                    if(find(board,i,j,word,0)) return true;
                }
            }
        }
        return false;
    }
    private boolean find(char[][] board, int i , int j, String word, int index){
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 
        || j >= board[0].length || board[i][j] == '#' 
        || board[i][j] != word.charAt(index)) return false;

        char ch = board[i][j];
        board[i][j] = '#';
        boolean isAvailable = find(board,i+1,j,word,index+1) ||
        find(board,i,j+1,word,index+1) ||
        find(board,i-1,j,word,index+1) ||
        find(board,i,j-1,word,index+1);
        board[i][j] = ch;
        return isAvailable;
    }
}
