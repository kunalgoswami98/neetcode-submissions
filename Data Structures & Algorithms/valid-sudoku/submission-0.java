class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] != '.'){
                    if(!checkValidity(board,i,j)) return false;
                }
            }
        }
        return true;
    }
    private boolean checkValidity(char[][] board, int currentRow, int currentColumn){
        
        //check rows
        for(int j = 0; j < board[0].length; j++){
            if(j == currentColumn) continue;
            if(board[currentRow][j] == board[currentRow][currentColumn]){
                return false;
            }
        }

        //check column
        for(int i = 0; i < board[0].length; i++){
            if(i == currentRow) continue;
            if(board[i][currentColumn] == board[currentRow][currentColumn]){
                return false;
            }
        }

        //check 3 * 3 matrix
        int rowStartingPoint = (currentRow / 3) * 3;
        int columnStartingPoint = (currentColumn / 3) * 3;

        for(int i = rowStartingPoint; i < rowStartingPoint+3; i++){
            for(int j = columnStartingPoint ; j < columnStartingPoint + 3 ; j++){
                if(i == currentRow && j == currentColumn) continue;
                if(board[i][j] == board[currentRow][currentColumn])
                    return false;
            }
        }
        return true;
    }
}
