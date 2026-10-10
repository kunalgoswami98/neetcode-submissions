class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            if(target >= matrix[i][0] && target <= matrix[i][col-1]){
                if(searchElement(0,col-1,matrix[i],target)){
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    private boolean searchElement(int left, int right, int[] nums, int target){
        if(left > right) return false;
        
        int mid = left + (right-left)/2;

        if(nums[mid] == target) return true;
        else if(nums[mid] < target) return searchElement(mid+1,right,nums,target);
        return searchElement(left,mid-1,nums,target);
    }
}
