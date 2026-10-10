class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void islandsAndTreasure(int[][] rooms) {
        int rowLength = rooms.length;
        int colLength = rooms[0].length;

        int max = Integer.MAX_VALUE;

        Queue<Pair> queue = new LinkedList<>();

        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col < colLength; col++){
                if(rooms[row][col] == 0){
                    queue.add(new Pair(row,col));
                }
            }
        }
        int distance = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Pair currentPair = queue.remove();
                int[] rowChanger = {-1,0,1,0};
                int[] colChanger = {0,-1,0,1};
                
                for(int i = 0; i < 4; i++){
                    int newRow = currentPair.row + rowChanger[i];
                    int newCol = currentPair.col + colChanger[i];

                    if(newRow >=0 && newRow < rowLength && newCol >= 0 && newCol < colLength && rooms[newRow][newCol] == max){
                        rooms[newRow][newCol] = Math.min(distance, rooms[newRow][newCol]);
                        queue.add(new Pair(newRow, newCol));
                    }
                }
            }
            distance++;
        }
    }
}
