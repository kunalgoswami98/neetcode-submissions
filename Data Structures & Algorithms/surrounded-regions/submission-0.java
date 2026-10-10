class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {
        int rowLength = board.length;
        int colLength = board[0].length;

        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength ; j++){
                if((i == 0 || j == 0 || i == rowLength-1 || j == colLength-1) && board[i][j] == 'O'){
                    queue.add(new Pair(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            Pair currentPosition = queue.poll();
            if(board[currentPosition.row][currentPosition.col] == 'O'){
                touchEveryO(board,currentPosition.row,currentPosition.col);
            }
        }

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength ; j++){
                if(board[i][j] == '*') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void touchEveryO(char[][] board, int row, int col) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O'){
            return;
        }

        board[row][col] = '*';

        int[] rowChanger = {-1,0,1,0};
        int[] colChanger = {0,-1,0,1};

        for(int i = 0; i < 4; i++){
            int newRow = row + rowChanger[i];
            int newCol = col + colChanger[i];

            touchEveryO(board,newRow,newCol);
        }
    }
}