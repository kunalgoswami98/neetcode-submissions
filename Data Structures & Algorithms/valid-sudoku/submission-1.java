class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Step1: Loop through each row
            // In a nested forLoop of the current row, loop through each element of the particular row
        for(int row=0; row<9; row++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0; i<9; i++) {
                if(board[row][i] == '.') continue;
                if(seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }


        //Step2: Loop through each column
            // In a nested forLoop of the current column, loop through each element of the particular column

        for(int col=0; col<9; col++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0; i<9; i++) {
                if(board[i][col] == '.') continue;
                if(seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

        //Step3: Loop through each Squares (3x3 boxes)
            // 2 nexted for loops one inside another to go though rows and columns of each squares

        for(int square=0; square<9; square++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if(board[row][col] == '.') continue;
                    if(seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
