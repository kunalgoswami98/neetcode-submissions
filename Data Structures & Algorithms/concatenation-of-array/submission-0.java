class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length*2];
        
        for(int i = 0; i < length*2; i++){
            arr[i] = nums[i% length];
        }
        return arr;
    }
}