class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        sumMatrix = new int[rowLength][colLength];

        for(int i = 0; i < rowLength; i++){
            int sum = 0;
            for(int j = 0; j < colLength; j++){
                sumMatrix[i][j] = sum + matrix[i][j];
                sum = sumMatrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for(int i = row1; i <= row2; i++){
            result += col1 == 0 ? sumMatrix[i][col2] : sumMatrix[i][col2] - sumMatrix[i][col1-1];
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */