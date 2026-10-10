class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if(length == 0) return new int[0];
        int[] output = new int[length];
        Arrays.fill(output, 1);
        for(int i = 1; i < length; i++){
            output[i] = nums[i-1] * output[i-1];
        }
        int temp = 1;
        for(int i = length-1; i >= 0; i--){
            output[i] = temp * output[i];
            temp = temp * nums[i];
        }
        return output;
    }
}  
