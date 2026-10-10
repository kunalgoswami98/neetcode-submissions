class Solution {
    List<List<Integer>> result;
    boolean[][] atlanticVisited;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowLength = heights.length;
        if(rowLength == 0) return new ArrayList<>();
        int colLength = heights[0].length;
        result = new ArrayList<>();
        boolean[][] visited = new boolean[rowLength][colLength];
        atlanticVisited = new boolean[rowLength][colLength];
        //DFS from pacific ocean
        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col < colLength; col++){
                if((row == 0 || col == 0) && !visited[row][col]){
                    solveDFS(heights, row, col, visited, true);
                }
            }
        }

        //DFS from Atlantic ocean
        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col < colLength; col++){
                if((row == rowLength-1 || col == colLength-1) && !atlanticVisited[row][col]){
                    solveDFS(heights, row, col, visited, false);
                }
            }
        }
        return result;
    }

    private void solveDFS(int[][] heights, int row, int col, boolean[][] visited, boolean pacificVisited){
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length){
            return;
        }

        if(pacificVisited){
            if(visited[row][col]){
                return; 
            }
            visited[row][col] = true;
        }
        else{
            if(atlanticVisited[row][col]) return;
            if(visited[row][col]){
                result.add(Arrays.asList(row,col));
            }
            atlanticVisited[row][col] = true;
        }
        int[] rowChanger = {-1,0,1,0};
        int[] colChanger = {0,-1,0,1};

        for(int i = 0; i < 4; i++){
            int newRow = row + rowChanger[i];
            int newCol = col + colChanger[i];
            if((newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length) && heights[newRow][newCol] >= heights[row][col]){
                solveDFS(heights, newRow, newCol, visited, pacificVisited);
            }
        }
    }
}