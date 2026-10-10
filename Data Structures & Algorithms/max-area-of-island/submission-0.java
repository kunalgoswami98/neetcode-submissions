class Solution {
    int currentIsland;
    int maxIsland;
    public int maxAreaOfIsland(int[][] grid) {
        maxIsland = 0;
        int rowLength = grid.length;
        if(rowLength == 0){
            return 0;
        }
        int colLength = grid[0].length;

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(grid[i][j] == 1){
                    currentIsland = 0;
                    findAreaOfIsland(grid, i, j);
                    maxIsland = Math.max(maxIsland, currentIsland);
                }
            }
        }

        return maxIsland;
    }

    private void findAreaOfIsland(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1){
            return;
        }

        currentIsland++;
        grid[row][col] = 0;
        findAreaOfIsland(grid, row+1, col);
        findAreaOfIsland(grid, row, col+1);
        findAreaOfIsland(grid, row-1, col);
        findAreaOfIsland(grid, row, col-1);

    }
}
