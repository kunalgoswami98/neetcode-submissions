class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int rowLength = grid.length;
        if(rowLength == 0) return 0;
        int colLength = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int totalFreshOranges = 0;
        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col < colLength; col++){
                if(grid[row][col] == 2){
                    queue.add(new Pair(row, col));
                }
                else if(grid[row][col] == 1){
                    totalFreshOranges++;
                }
            }
        }
        if(totalFreshOranges == 0) return 0;
        int totalTimeTaken = 0;
        int rottenWithTime = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Pair currentPair = queue.remove();
                int[] rowChanger = {-1,0,1,0};
                int[] colChanger = {0,-1,0,1};

                for(int i = 0; i < 4; i++){
                    int newRow = currentPair.row + rowChanger[i];
                    int newCol = currentPair.col + colChanger[i];

                    if(newRow >= 0 && newRow < rowLength && newCol >= 0 && newCol < colLength && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        rottenWithTime++;
                        
                        queue.add(new Pair(newRow, newCol));
                    }
                }
            }
            totalTimeTaken++;
        }
        return rottenWithTime == totalFreshOranges ? totalTimeTaken-1 : -1;
    }
}